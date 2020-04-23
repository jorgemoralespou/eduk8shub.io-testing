package com.eduk8s.hub.model.eduk8s;

import java.util.List;
import java.util.Objects;

public class Eduk8sCatalog {
    private Eduk8sPortal portal;
    private List<Eduk8sEnvironment> environments;


    public Eduk8sCatalog() {
    }

    public Eduk8sCatalog(Eduk8sPortal portal, List<Eduk8sEnvironment> environments) {
        this.portal = portal;
        this.environments = environments;
    }

    public List<Eduk8sEnvironment> getEnvironments() {
        return this.environments;
    }

    public void setEnvironments(List<Eduk8sEnvironment> environments) {
        this.environments = environments;
    }

    public Eduk8sPortal getPortal() {
        return portal;
    }

    public void setPortal(Eduk8sPortal portal) {
        this.portal = portal;
    }

    public Eduk8sCatalog environments(List<Eduk8sEnvironment> environments) {
        this.environments = environments;
        return this;
    }

    public Eduk8sCatalog portal(Eduk8sPortal portal){
        this.portal = portal;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Eduk8sCatalog)) {
            return false;
        }
        Eduk8sCatalog eduk8sCatalog = (Eduk8sCatalog) o;
        return Objects.equals(environments, eduk8sCatalog.environments) &&
               Objects.equals(portal, eduk8sCatalog.portal);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(environments);
    }

    @Override
    public String toString() {
        return "{" +
        " portal='" + getPortal() + "'" +
        ", environments='" + getEnvironments() + "'" +
            "}";
    }

}