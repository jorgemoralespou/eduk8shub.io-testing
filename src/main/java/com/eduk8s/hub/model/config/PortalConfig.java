package com.eduk8s.hub.model.config;

import java.util.Objects;

public class PortalConfig {
    private String name;
    private String url;
    private RobotConfig robot;

    public PortalConfig() {
    }

    public PortalConfig(String name, String url, RobotConfig robot) {
        this.name = name;
        this.url = url;
        this.robot = robot;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RobotConfig getRobot() {
        return this.robot;
    }

    public void setRobot(RobotConfig robot) {
        this.robot = robot;
    }

    public PortalConfig name(String name) {
        this.name = name;
        return this;
    }

    public PortalConfig url(String url) {
        this.url = url;
        return this;
    }

    public PortalConfig robot(RobotConfig robot) {
        this.robot = robot;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PortalConfig)) {
            return false;
        }
        PortalConfig portal = (PortalConfig) o;
        return Objects.equals(name, portal.name) && Objects.equals(url, portal.url) && Objects.equals(robot, portal.robot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, robot);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", url='" + getUrl() + "'" +
            ", robot='" + getRobot() + "'" +
            "}";
    }

}