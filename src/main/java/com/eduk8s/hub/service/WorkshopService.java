package com.eduk8s.hub.service;

import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import com.eduk8s.hub.config.Eduk8sPortalConfig;
import com.eduk8s.hub.config.HubConfig;
import com.eduk8s.hub.model.hub.TrainingPortal;
import com.eduk8s.hub.model.hub.WorkshopDefinition;
import com.eduk8s.hub.model.hub.WorkshopLocation;
import com.eduk8s.hub.model.hub.WorkshopUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Provides Workshop information from backend TrainingPortals
 * 
 */
@Service
public class WorkshopService {

    private static final Logger logger = LoggerFactory.getLogger(WorkshopService.class);

    private Map<String, TrainingPortal> trainingPortals = new HashMap<String, TrainingPortal>();

    private HubConfig hubConfig;

    private Instant lastQueryTime;

    private Map<WorkshopUID, List<WorkshopLocation>> workshops;

    public WorkshopService(Eduk8sPortalConfig config, HubConfig hubConfig){
        this.hubConfig = hubConfig;
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
        Instant now = Instant.now();
        int refreshTimeout = hubConfig.getRefreshTimeout();
        logger.debug("refreshTimeout: {}", refreshTimeout);
        // If NOT refreshTime seconds have elapsed since last query, do not update
        if (this.lastQueryTime!=null && now.isBefore(lastQueryTime.plusSeconds(refreshTimeout))){
            logger.info("We will not refresh info from backends as not enough time has passed since last query");
            return;
        }else{
            logger.info("Update info from backends");
            this.lastQueryTime = now;
        }
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
        // Update workshops Map
        workshops = new HashMap<WorkshopUID, List<WorkshopLocation>>();
        trainingPortals.values().forEach(tp -> {
            tp.getWorkshopUIDInfo(workshops);
        });
    }

    public List<TrainingPortal> getTrainingPortals(){
        updatePortalInfo();
        return trainingPortals.values().stream().collect(Collectors.toList());
    }

    public TrainingPortal getTrainingPortal(String name){
        updatePortalInfo(name);
        return trainingPortals.get(name);
    }

    /*
    public WorkshopDefinition getWorkshop(String workshopName){
        updatePortalInfo();
        for (TrainingPortal trainingPortal: trainingPortals.values()){
            for (WorkshopEnvironment environment: trainingPortal.getEnvironments().values()){
                if (environment.getWorkshopName().equals(workshopName)){
                    return environment.getWorkshop();
                }
            }
        }
        return null;
    }*/

    public WorkshopDefinition getWorkshop(String workshopUID){
        updatePortalInfo();
        Random rand = new Random();
        WorkshopUID wid = WorkshopUID.fromString(workshopUID);
        logger.debug("wid: {}", wid);
        List<WorkshopLocation> wsl = workshops.get(wid);
        WorkshopLocation loc = wsl.get(rand.nextInt(wsl.size()));

        return trainingPortals.get(loc.getTrainingPortal()).getEnvironments().get(loc.getEnvironment()).getWorkshop();
    }
    
    /*
    public String startWorkshop(String workshopUID, String callbackUrl){
        logger.info("Start Workshop {}", workshopUID);
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
    */
    public String startWorkshop(String workshopUID, String callbackUrl){
        logger.info("Start Workshop {}", workshopUID);

        Random rand = new Random();
        WorkshopUID wid = WorkshopUID.fromString(workshopUID);
        List<WorkshopLocation> wsl = workshops.get(wid);
        WorkshopLocation loc = wsl.get(rand.nextInt(wsl.size()));
        TrainingPortal tp = trainingPortals.get(loc.getTrainingPortal());

        int retries = 1;
        String workshopLaunchUrl = tp.startWorkshop(loc.getEnvironment(), callbackUrl, retries);
        return workshopLaunchUrl;
    }

    public Set<WorkshopDefinition> getWorkshops(){
        updatePortalInfo();
        Set<WorkshopDefinition> workshopsDef = new HashSet<WorkshopDefinition>();
        trainingPortals.values().forEach(tp -> {
            workshopsDef.addAll(tp.getWorkshops());
        });
        logger.info("We just got {} workshops to show", workshopsDef.size());
        return workshopsDef;
    }

    public Map<WorkshopUID, List<WorkshopLocation>> getWorkshopsUID(){
        updatePortalInfo();
        return workshops;
    }

}