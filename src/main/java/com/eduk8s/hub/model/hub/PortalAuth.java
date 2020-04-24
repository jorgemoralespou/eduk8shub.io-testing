package com.eduk8s.hub.model.hub;

import java.time.LocalTime;
import java.util.Objects;

import com.eduk8s.hub.model.eduk8s.AuthResponse;

public class PortalAuth {

    private AuthResponse authResponse;

    private LocalTime authReponseTime;

    // 30 seconds
    private static final int overteadTime = 30;

    public PortalAuth(AuthResponse authResp){
        this.authResponse = authResp;
        authReponseTime = LocalTime.now();
    }

    /**
     * PortalAuth is still valid if it hasn't reached 60 seconds before the expiration time
     * @return
     */
    public Boolean isValid(){
        return authReponseTime.plusSeconds(authResponse.expires_in - overteadTime).isBefore(LocalTime.now());
    }

    public String getAccessToken(){
        return authResponse.access_token;
    }

    public AuthResponse getAuthResponse(){
        return authResponse;
    }

    public LocalTime getAuthReponseTime() {
        return this.authReponseTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PortalAuth)) {
            return false;
        }
        PortalAuth portalAuth = (PortalAuth) o;
        return Objects.equals(authResponse, portalAuth.authResponse) && Objects.equals(authReponseTime, portalAuth.authReponseTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authResponse, authReponseTime);
    }

    @Override
    public String toString() {
        return "{" +
            " authResponse='" + getAuthResponse() + "'" +
            ", authReponseTime='" + getAuthReponseTime() + "'" +
            "}";
    }

}