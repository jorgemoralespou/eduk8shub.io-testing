package com.eduk8s.hub.config;

import java.util.List;
import java.util.Objects;

import com.eduk8s.hub.model.config.PortalConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.ConstructorBinding;


@ConfigurationProperties(prefix = "catalog")
// @ConstructorBinding
public class Eduk8sPortalConfig {

    public static final String OAUTH_ENDPOINT = "/oauth2/token/";

    public static final String CATALOG_ENDPOINT = "/workshops/catalog/environments/";

    //@Value("${catalog.portals}")
    private List<PortalConfig> portals;

    public Eduk8sPortalConfig() {
    }

    public Eduk8sPortalConfig(List<PortalConfig> portals) {
        this.portals = portals;
    }

    public List<PortalConfig> getPortals() {
        return this.portals;
    }

    public void setPortals(List<PortalConfig> portals) {
        this.portals = portals;
    }

    public Eduk8sPortalConfig portals(List<PortalConfig> portals) {
        this.portals = portals;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Eduk8sPortalConfig)) {
            return false;
        }
        Eduk8sPortalConfig eduk8sPortalConfig = (Eduk8sPortalConfig) o;
        return Objects.equals(portals, eduk8sPortalConfig.portals);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(portals);
    }

    @Override
    public String toString() {
        return "{" + " portals='" + getPortals() + "'" + "}";
    }

}