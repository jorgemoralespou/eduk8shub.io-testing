package com.eduk8s.hub.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eduk8s.hub.model.hub.TrainingPortal;
import com.eduk8s.hub.model.hub.WorkshopDefinition;
import com.eduk8s.hub.model.hub.WorkshopLocation;
import com.eduk8s.hub.model.hub.WorkshopUID;
import com.eduk8s.hub.service.WorkshopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {


    @Autowired
    private WorkshopService service;


    @RequestMapping("/uids")
    public ResponseEntity<Map<WorkshopUID, List<WorkshopLocation>>> getWorkshopUIDs(){
        Map<WorkshopUID, List<WorkshopLocation>> workshops = service.getWorkshopsUID();
        return new ResponseEntity<Map<WorkshopUID, List<WorkshopLocation>>>(workshops, HttpStatus.OK);
    }

    @RequestMapping("/workshops")
    public ResponseEntity<Set<WorkshopDefinition>> getWorkshops(){
        Set<WorkshopDefinition> workshops = service.getWorkshops();
        return new ResponseEntity<Set<WorkshopDefinition>>(workshops, HttpStatus.OK);
    }

    @RequestMapping("/workshop/{name}")
    public ResponseEntity<WorkshopDefinition> getWorkshop(@PathVariable String name){
        WorkshopDefinition workshop = service.getWorkshop(name);
        return new ResponseEntity<WorkshopDefinition>(workshop, HttpStatus.OK);
    }

    @RequestMapping("/trainingportals")
    public ResponseEntity<List<TrainingPortal>> getTrainingPortals(){
        List<TrainingPortal> portals = service.getTrainingPortals();
        return new ResponseEntity<List<TrainingPortal>>(portals, HttpStatus.OK);
    }

    @RequestMapping("/trainingportal/{name}")
    public ResponseEntity<TrainingPortal> getTrainingPortal(@PathVariable String name){
        TrainingPortal portal = service.getTrainingPortal(name);
        return new ResponseEntity<TrainingPortal>(portal, HttpStatus.OK);
    }

}