package com.eduk8s.hub.service;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.eduk8s.hub.config.Eduk8sPortalConfig;
import com.eduk8s.hub.config.HubConfig;
import com.eduk8s.hub.model.hub.TrainingPortal;
import com.eduk8s.hub.model.hub.WorkshopDefinition;
import com.eduk8s.hub.model.hub.WorkshopEnvironment;

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

    private LocalTime lastQueryTime;

//    private Map<String, WorkshopDefinition> workshops;
    private Set<WorkshopDefinition> workshops;


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
        LocalTime now = LocalTime.now();
        // If NOT refreshTime seconds have elapsed since last query, do not update
        if (lastQueryTime!=null && now.isBefore(lastQueryTime.plusSeconds(hubConfig.getRefreshTimeout()))){
            return;
        }
        this.lastQueryTime = now;
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

    public List<TrainingPortal> getTrainingPortals(){
        updatePortalInfo();
        return trainingPortals.values().stream().collect(Collectors.toList());
    }

    public TrainingPortal getTrainingPortal(String name){
        updatePortalInfo(name);
        return trainingPortals.get(name);
    }

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