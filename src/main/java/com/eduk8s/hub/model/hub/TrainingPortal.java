package com.eduk8s.hub.model.hub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.eduk8s.hub.config.Eduk8sPortalConfig;
import com.eduk8s.hub.exception.PortalAuthenticationException;
import com.eduk8s.hub.model.config.PortalConfig;
import com.eduk8s.hub.model.eduk8s.AuthResponse;
import com.eduk8s.hub.model.eduk8s.Eduk8sCatalog;
import com.eduk8s.hub.model.eduk8s.Eduk8sSessionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import reactor.core.publisher.Mono;

public class TrainingPortal {

    private static final Logger logger = LoggerFactory.getLogger(TrainingPortal.class);
    
    private String name;
    private String url;
    private Robot  robot;
    private Map<String, WorkshopEnvironment> environments = new HashMap<String,WorkshopEnvironment>();

    private WebClient webClient;

    private PortalAuth portalAuth;

	public TrainingPortal() {
    }

    public TrainingPortal(PortalConfig pc) {
        // TODO: Maybe we need to compute the name from the URL
        this.name = pc.getName();
        this.url = pc.getUrl();
        this.robot = new Robot(pc.getRobot());
        this.webClient = WebClient.builder().baseUrl(this.url).build();
    }


    public TrainingPortal(String name, String url, Robot robot, Map<String,WorkshopEnvironment> environments) {
        this.name = name;
        this.url = url;
        this.robot = robot;
        this.environments = environments;
    }

    public List<WorkshopDefinition> getWorkshops(){
        List<WorkshopDefinition> def = new ArrayList<WorkshopDefinition>();
        environments.values().forEach(env -> {
            def.add(env.getWorkshop());
        });
        return def;
    }

    public void updateInfo(){
        internalUpdateInfo(1);
    }

    private void internalUpdateInfo(int retries){
        // authenticate
        if (portalAuth == null){
            MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
            map.add("grant_type", "password");
            map.add("username",robot.getUsername());
            map.add("password",robot.getPassword());
    
            try{
                AuthResponse response = this.webClient.post()
                        .uri(Eduk8sPortalConfig.OAUTH_ENDPOINT)
                        .headers(headers -> headers.setBasicAuth(robot.getClientId(), robot.getClientSecret()))
                        .bodyValue(map)
                        .retrieve()
                        .bodyToMono(AuthResponse.class)
                        .onErrorResume(WebClientResponseException.class, ex -> Mono.error(ex))
                        .block();
                portalAuth = new PortalAuth(response);
            }catch(WebClientResponseException e){
                throw new PortalAuthenticationException("Have you verified if the robot credentials are correct?", e);
            }
        }
        // refresh
        if ( ! portalAuth.isValid()){
            logger.info("Token is no longer valid. Let's ask for a new one");
            MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
            map.add("grant_type", "refresh_token");
            map.add("refresh_token",portalAuth.getAuthResponse().refresh_token);
    
            try{
                AuthResponse response = this.webClient.post()
                        .uri(Eduk8sPortalConfig.OAUTH_ENDPOINT)
                        .bodyValue(map)
                        .retrieve()
                        .bodyToMono(AuthResponse.class)
                        .onErrorResume(WebClientResponseException.class, ex -> Mono.error(ex))
                        .block();
                portalAuth = new PortalAuth(response);
            }catch(WebClientResponseException e){
                throw new PortalAuthenticationException("Have you verified if the robot credentials are correct?", e);
            }
        }
        Eduk8sCatalog eduk8sCatalog = null;
        try{
            // If we have a valid Token
            eduk8sCatalog = this.webClient.get()
                    .uri(Eduk8sPortalConfig.CATALOG_ENDPOINT)
                    .headers(headers -> headers.setBearerAuth(portalAuth.getAccessToken()))
                    .retrieve().bodyToMono(Eduk8sCatalog.class).block();
        }catch(WebClientResponseException e){
            portalAuth = null;
            // TODO: If it's because it's invalid we should retry once
            if (retries>0){
              internalUpdateInfo(0);
            }
            return;
        }
//        logger.debug("TrainingPortal: {}", this);
//        logger.debug("eduk8sCatalog: {}", eduk8sCatalog);
        if ( eduk8sCatalog != null){
            eduk8sCatalog.getEnvironments().forEach(eduk8sEnv -> {
//                logger.info("eduk8senv: {}",eduk8sEnv);
                WorkshopEnvironment we = new WorkshopEnvironment(eduk8sEnv);
//                logger.info("WorkshopEnvironment: {}", we);
                environments.put(we.getName(), we);
            });
        }
//        logger.debug("TrainingPortal: {}", this);
    }

    public String startWorkshop(String workshopName, String callbackUrl) {
        // TODO: Verify the token is still valid and if not, refresh
        // If we have a valid Token
        logger.debug("Using token: {}", portalAuth);
        Eduk8sSessionResponse response = this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/workshops/environment/{workshopName}/request/")
                .queryParam("redirect_url", callbackUrl)
                .build(workshopName))
                .headers(headers -> headers.setBearerAuth(portalAuth.getAccessToken()))
                .retrieve().bodyToMono(Eduk8sSessionResponse.class).block();

        logger.info("Started session '{}' at url '{}'", response.getSession(), response.getUrl());
        return this.getUrl() + response.getUrl();
    }
    

	public void getWorkshopUIDInfo(Map<WorkshopUID,List<WorkshopLocation>> workshops) {
        environments.values().forEach(env -> {
            WorkshopUID uid = new WorkshopUID(env.getWorkshop());
            WorkshopLocation location = new WorkshopLocation(this, env);

            // If there's an entry ADDITION to it
            if (workshops.containsKey(uid)){
                List<WorkshopLocation> locs = workshops.get(uid);
                locs.add(location);
                workshops.put(uid, locs);
            }
            // If there's NO entry, ADD it
            else{
                List<WorkshopLocation> locs = new ArrayList<WorkshopLocation>();
                locs.add(location);
                workshops.put(uid, locs);
            }
            
        });
	}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Robot getRobot() {
        return this.robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public Map<String,WorkshopEnvironment> getEnvironments() {
        return this.environments;
    }

    public void setEnvironments(Map<String,WorkshopEnvironment> environments) {
        this.environments = environments;
    }

    public TrainingPortal name(String name) {
        this.name = name;
        return this;
    }

    public TrainingPortal url(String url) {
        this.url = url;
        return this;
    }

    public TrainingPortal robot(Robot robot) {
        this.robot = robot;
        return this;
    }

    public TrainingPortal environments(Map<String,WorkshopEnvironment> environments) {
        this.environments = environments;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TrainingPortal)) {
            return false;
        }
        TrainingPortal trainingPortal = (TrainingPortal) o;
        return Objects.equals(name, trainingPortal.name) && Objects.equals(url, trainingPortal.url) && Objects.equals(robot, trainingPortal.robot) && Objects.equals(environments, trainingPortal.environments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, robot, environments);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", url='" + getUrl() + "'" +
            ", robot='" + getRobot() + "'" +
            ", environments='" + getEnvironments() + "'" +
            "}";
    }

}