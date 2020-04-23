package com.eduk8s.hub.model.config;

import java.util.Objects;

public class RobotConfig {
    private String username;
    private String password;
    private String clientId;
    private String clientSecret;


    public RobotConfig() {
    }

    public RobotConfig(String username, String password, String clientId, String clientSecret) {
        this.username = username;
        this.password = password;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return this.clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public RobotConfig username(String username) {
        this.username = username;
        return this;
    }

    public RobotConfig password(String password) {
        this.password = password;
        return this;
    }

    public RobotConfig clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public RobotConfig clientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RobotConfig)) {
            return false;
        }
        RobotConfig robot = (RobotConfig) o;
        return Objects.equals(username, robot.username) && Objects.equals(password, robot.password) && Objects.equals(clientId, robot.clientId) && Objects.equals(clientSecret, robot.clientSecret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, clientId, clientSecret);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", clientId='" + getClientId() + "'" +
            ", clientSecret='" + getClientSecret() + "'" +
            "}";
    }
    
}