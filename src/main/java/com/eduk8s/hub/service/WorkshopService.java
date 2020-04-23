package com.eduk8s.hub.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.eduk8s.hub.config.Eduk8sPortalConfig;
import com.eduk8s.hub.exception.PortalAuthenticationException;
import com.eduk8s.hub.model.eduk8s.AuthResponse;
import com.eduk8s.hub.model.eduk8s.Eduk8sCatalog;
import com.eduk8s.hub.model.hub.TrainingPortal;
import com.eduk8s.hub.model.hub.WorkshopDefinition;
import com.eduk8s.hub.model.hub.WorkshopEnvironment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import reactor.core.publisher.Mono;

/**
 * Provides Workshop information from backend TrainingPortals
 * 
 */
@Service
public class WorkshopService {

    private static final Logger logger = LoggerFactory.getLogger(WorkshopService.class);

    private Map<String, TrainingPortal> trainingPortals = new HashMap<String, TrainingPortal>();

//    private Map<String, WorkshopDefinition> workshops;
    private Set<WorkshopDefinition> workshops;


    public WorkshopService(Eduk8sPortalConfig config){
        if (config.getPortals()!=null){
            config.getPortals().forEach(portalConfig -> {
                TrainingPortal tp = new TrainingPortal(portalConfig);
                trainingPortals.put(tp.getName(), tp);
            });
        }else{
            logger.error("THERE'S NO CONFIGURATION DEFINED");
        }
    }

    public void updatePortalInfo(){
        updatePortalInfo(null);
    }

    public void updatePortalInfo(String portalName){
        if (portalName!=null){
            TrainingPortal tp = trainingPortals.get(portalName);
            if (tp != null){
                tp.updateInfo();
            }
        }else{
            trainingPortals.values().forEach(tp -> {
                tp.updateInfo();
            });
        }
    }

    /*
    public TrainingPortal getTrainingPortal(String name){
        return null;
    }
    */

    public WorkshopDefinition getWorkshop(String workshopName){
        for (TrainingPortal trainingPortal: trainingPortals.values()){
            for (WorkshopEnvironment environment: trainingPortal.getEnvironments().values()){
                if (environment.getWorkshopName().equals(workshopName)){
                    return environment.getWorkshop();
                }
            }
        }
        return null;
    }

    public String startWorkshop(String workshopName, String callbackUrl){
        logger.info("Start Workshop {}", workshopName);
        
        // Find which training portal has the workshop
        for (TrainingPortal trainingPortal: trainingPortals.values()){
            for (WorkshopEnvironment environment: trainingPortal.getEnvironments().values()){
                if (environment.getWorkshopName().equals(workshopName)){
                    // Launch and return
                    logger.debug("Launching workhsopenvironment {} at portal {}", environment.getName(), trainingPortal.getUrl());

                    String workshopLaunchUrl = trainingPortal.startWorkshop(environment.getName(), callbackUrl);
                    return workshopLaunchUrl;
                }
            } 
        }
        return null;
    }

    public Set<WorkshopDefinition> getWorkshops(){
        updatePortalInfo();
        workshops = new HashSet<WorkshopDefinition>();
        trainingPortals.values().forEach(tp -> {
            workshops.addAll(tp.getWorkshops());
        });
        logger.info("We just got {} workshops to show", workshops.size());
        return workshops;
    }

}