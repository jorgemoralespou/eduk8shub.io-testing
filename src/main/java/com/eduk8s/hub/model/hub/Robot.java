package com.eduk8s.hub.model.hub;

import java.util.Objects;

import com.eduk8s.hub.model.config.RobotConfig;

public class Robot {
    private String username;
    private String password;
    private String clientId;
    private String clientSecret;


    public Robot() {
    }

    public Robot(String username, String password, String clientId, String clientSecret) {
        this.username = username;
        this.password = password;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public Robot(RobotConfig config) {
        this.username = config.getUsername();
        this.password = config.getPassword();
        this.clientId = config.getClientId();
        this.clientSecret = config.getClientSecret();
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

    public Robot username(String username) {
        this.username = username;
        return this;
    }

    public Robot password(String password) {
        this.password = password;
        return this;
    }

    public Robot clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public Robot clientSecret(String clientSecret) {
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
        return Objects.equals(username, robot.getUsername()) && Objects.equals(password, robot.getPassword()) && Objects.equals(clientId, robot.getClientId()) && Objects.equals(clientSecret, robot.getClientSecret());
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