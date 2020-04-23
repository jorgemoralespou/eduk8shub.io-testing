package com.eduk8s.hub.model.hub;

import java.util.Objects;

import com.eduk8s.hub.model.eduk8s.Eduk8sEnvironment;

public class WorkshopEnvironment {
    private String name;
    private String workshopName;
    private WorkshopDefinition workshop;
    // TODO: Add additional fields from the workshop if needed

    public WorkshopEnvironment() {
    }

    public WorkshopEnvironment(Eduk8sEnvironment env) {
        this.name = env.getName();
        this.workshopName = env.getWorkshop().getName();
        this.workshop = new WorkshopDefinition(env.getWorkshop());
    }

    public WorkshopEnvironment(String name, String workshopName, WorkshopDefinition workshop) {
        this.name = name;
        this.workshopName = workshopName;
        this.workshop = workshop;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkshopName() {
        return this.workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public WorkshopDefinition getWorkshop() {
        return this.workshop;
    }

    public void setWorkshop(WorkshopDefinition workshop) {
        this.workshop = workshop;
    }

    public WorkshopEnvironment name(String name) {
        this.name = name;
        return this;
    }

    public WorkshopEnvironment workshopName(String workshopName) {
        this.workshopName = workshopName;
        return this;
    }

    public WorkshopEnvironment workshop(WorkshopDefinition workshop) {
        this.workshop = workshop;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WorkshopEnvironment)) {
            return false;
        }
        WorkshopEnvironment workshopEnvironment = (WorkshopEnvironment) o;
        return Objects.equals(name, workshopEnvironment.name) && Objects.equals(workshopName, workshopEnvironment.workshopName) && Objects.equals(workshop, workshopEnvironment.workshop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, workshopName, workshop);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", workshopName='" + getWorkshopName() + "'" +
            ", workshop='" + getWorkshop() + "'" +
            "}";
    }

}
