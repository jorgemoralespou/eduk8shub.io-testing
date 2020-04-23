package com.eduk8s.hub.controller;

import java.util.Set;

import com.eduk8s.hub.model.hub.WorkshopDefinition;
import com.eduk8s.hub.service.WorkshopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {


    @Autowired
    private WorkshopService service;


    @RequestMapping("/catalog")
    public ResponseEntity<Set<WorkshopDefinition>> getWorkshops(){
        Set<WorkshopDefinition> workshops = service.getWorkshops();
        return new ResponseEntity<Set<WorkshopDefinition>>(workshops, HttpStatus.OK);
    }

}