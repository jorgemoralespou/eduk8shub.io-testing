package com.eduk8s.hub.service;

import com.eduk8s.hub.model.HubWorkshop;
import com.eduk8s.hub.model.eduk8s.Eduk8sCatalog;
import com.eduk8s.hub.model.eduk8s.Eduk8sEnvironment;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

@Service
public class MockDataService {

    @Value("${json.mock.environments}")
    String mockEnvironmentFile;

    @Value("${json.mock.hub}")
    String mockHubFile;

    Eduk8sCatalog catalog;
    List<HubWorkshop> hubWorkshops;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        File catalogFile, hubFile;
        if ((catalogFile=getFile(mockEnvironmentFile))!=null){
          catalog = jsonMapper.readValue(catalogFile, new TypeReference<Eduk8sCatalog>() {});
        }
        if ((hubFile=getFile(mockHubFile))!=null){
            hubWorkshops = jsonMapper.readValue(hubFile, new TypeReference<List<HubWorkshop>>() {});
        }
    }

    public List<Eduk8sEnvironment> getEnvironmentsFromCatalog(String context) {
        // Filter the list based on criteria
        return catalog.getEnvironments().stream().filter(environment -> checkIfMatches(environment, context)).collect(Collectors.toList());
    }

    public List<HubWorkshop> getWorkshops(String context) {
        // Filter the list based on criteria
        return hubWorkshops.stream().filter(workshop -> checkIfMatches(workshop, context)).collect(Collectors.toList());
    }

    private boolean checkIfMatches(Eduk8sEnvironment environment, String context) {
        // In case we want to filter conditions of environments
        return true;
    }

    private boolean checkIfMatches(HubWorkshop workshop, String context) {
        // In case we want to filter conditions of environments
        return true;
    }

    private File getFile(String filepath) {
        try{
          return new ClassPathResource(filepath).getFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}