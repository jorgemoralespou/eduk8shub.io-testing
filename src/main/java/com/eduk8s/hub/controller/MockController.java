package com.eduk8s.hub.controller;

import java.util.List;
import java.util.Set;

import com.eduk8s.hub.model.eduk8s.AuthResponse;
import com.eduk8s.hub.model.eduk8s.Eduk8sCatalog;
import com.eduk8s.hub.model.eduk8s.Eduk8sEnvironment;
import com.eduk8s.hub.model.hub.WorkshopDefinition;
import com.eduk8s.hub.model.HubWorkshop;
import com.eduk8s.hub.service.MockDataService;
import com.eduk8s.hub.service.WorkshopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock")
public class MockController {

    @Autowired
    private WorkshopService service;

    @Autowired
    private MockDataService mockData;

    @RequestMapping("/workshops")
    public ResponseEntity<List<HubWorkshop>> workshops(){
        List<HubWorkshop> workshops = mockData.getWorkshops("void");
        return new ResponseEntity<List<HubWorkshop>>(workshops, HttpStatus.OK);
    }

    /*
    @RequestMapping("/auth")
    public ResponseEntity<AuthResponse> auth(){
        return new ResponseEntity<AuthResponse>(service.getAuthToken(), HttpStatus.OK);
    }
    */

    @RequestMapping("/catalog")
    public ResponseEntity<Set<WorkshopDefinition>> getWorkshops(){
        Set<WorkshopDefinition> workshops = service.getWorkshops();
        return new ResponseEntity<Set<WorkshopDefinition>>(workshops, HttpStatus.OK);
    }

    @RequestMapping("/environments")
    public ResponseEntity<List<Eduk8sEnvironment>> environments(){
        List<Eduk8sEnvironment> envs = mockData.getEnvironmentsFromCatalog("void");
        return new ResponseEntity<List<Eduk8sEnvironment>>(envs, HttpStatus.OK);
    }

}