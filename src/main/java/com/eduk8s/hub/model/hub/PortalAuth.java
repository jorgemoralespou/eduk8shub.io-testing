package com.eduk8s.hub.model.hub;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Objects;

import com.eduk8s.hub.model.eduk8s.AuthResponse;

public class PortalAuth {

    private AuthResponse authResponse;

    private Instant authReponseTime;

    // 30 seconds
    private static final int overteadTime = 30;

    public PortalAuth(AuthResponse authResp){
        this.authResponse = authResp;
        authReponseTime = Instant.now();
    }

    /**
     * PortalAuth is still valid if it hasn't reached 60 seconds before the expiration time
     * @return
     */
    public Boolean isValid(){
        Duration expiryDuration = Duration.ofSeconds(authResponse.expires_in - overteadTime);
        Duration.between(Instant.now(), authReponseTime);
        return Duration.between(authReponseTime, Instant.now()).compareTo(expiryDuration)<0;
    }

    public String getAccessToken(){
        return authResponse.access_token;
    }

    public AuthResponse getAuthResponse(){
        return authResponse;
    }

    public Instant getAuthReponseTime() {
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

    public static void main(String[] args) {
        PortalAuth p = new PortalAuth(new AuthResponse("a",60, "a","b","c"));
        PortalAuth p1 = new PortalAuth(new AuthResponse("a",28, "a","b","c"));
        PortalAuth p2 = new PortalAuth(new AuthResponse("a",29, "a","b","c"));
        PortalAuth p3 = new PortalAuth(new AuthResponse("a",30, "a","b","c"));
        PortalAuth p4 = new PortalAuth(new AuthResponse("a",31, "a","b","c"));
        PortalAuth p5 = new PortalAuth(new AuthResponse("a",32, "a","b","c"));

        System.out.println("[t] Portal Config is valid: " + p.isValid());
        System.out.println("[f] p1 is valid: " + p1.isValid());
        System.out.println("[f] p2 is valid: " + p2.isValid());
        System.out.println("[f] p3 is valid: " + p3.isValid());
        System.out.println("[t] p4 is valid: " + p4.isValid());
        System.out.println("[t] p5 is valid: " + p5.isValid());
    }

}