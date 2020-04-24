package com.eduk8s.hub.config;

import java.util.Objects;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "hub")
public class HubConfig {

    private int refreshTimeout;


    public HubConfig() {
    }

    public HubConfig(int refreshTimeout) {
        this.refreshTimeout = refreshTimeout;
    }

    public int getRefreshTimeout() {
        return this.refreshTimeout;
    }

    public void setRefreshTimeout(int refreshTimeout) {
        this.refreshTimeout = refreshTimeout;
    }

    public HubConfig refreshTimeout(int refreshTimeout) {
        this.refreshTimeout = refreshTimeout;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HubConfig)) {
            return false;
        }
        HubConfig hubConfig = (HubConfig) o;
        return refreshTimeout == hubConfig.refreshTimeout;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(refreshTimeout);
    }

    @Override
    public String toString() {
        return "{" +
            " refreshTimeout='" + getRefreshTimeout() + "'" +
            "}";
    }

}