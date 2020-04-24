package com.eduk8s.hub.model.hub;

import java.util.Objects;

public class WorkshopLocation {
    private String trainingPortal;
    private String environment;
    private String workshop;


    public WorkshopLocation() {
    }

    public WorkshopLocation(TrainingPortal trainingPortal, WorkshopEnvironment environment) {
        this.trainingPortal = trainingPortal.getName();
        this.environment = environment.getName();
        this.workshop = environment.getWorkshopName();
    }

    public WorkshopLocation(String trainingPortal, String environment, String workshop) {
        this.trainingPortal = trainingPortal;
        this.environment = environment;
        this.workshop = workshop;
    }

    public String getTrainingPortal() {
        return this.trainingPortal;
    }

    public void setTrainingPortal(String trainingPortal) {
        this.trainingPortal = trainingPortal;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getWorkshop() {
        return this.workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public WorkshopLocation trainingPortal(String trainingPortal) {
        this.trainingPortal = trainingPortal;
        return this;
    }

    public WorkshopLocation environment(String environment) {
        this.environment = environment;
        return this;
    }

    public WorkshopLocation workshop(String workshop) {
        this.workshop = workshop;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WorkshopLocation)) {
            return false;
        }
        WorkshopLocation workshopLocation = (WorkshopLocation) o;
        return Objects.equals(trainingPortal, workshopLocation.trainingPortal) && Objects.equals(environment, workshopLocation.environment) && Objects.equals(workshop, workshopLocation.workshop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainingPortal, environment, workshop);
    }

    @Override
    public String toString() {
        return "{" +
            " trainingPortal='" + getTrainingPortal() + "'" +
            ", environment='" + getEnvironment() + "'" +
            ", workshop='" + getWorkshop() + "'" +
            "}";
    }


}