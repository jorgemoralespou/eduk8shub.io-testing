package com.eduk8s.hub.model.eduk8s;

import java.util.Objects;

public class AuthResponse {
    public String access_token;
    public int expires_in;
    public String token_type;
    public String scope;
    public String refresh_token;

    public AuthResponse() {
    }

    public AuthResponse(String access_token, int expires_in, String token_type, String scope, String refresh_token) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.token_type = token_type;
        this.scope = scope;
        this.refresh_token = refresh_token;
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return this.expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getToken_type() {
        return this.token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRefresh_token() {
        return this.refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public AuthResponse access_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public AuthResponse expires_in(int expires_in) {
        this.expires_in = expires_in;
        return this;
    }

    public AuthResponse token_type(String token_type) {
        this.token_type = token_type;
        return this;
    }

    public AuthResponse scope(String scope) {
        this.scope = scope;
        return this;
    }

    public AuthResponse refresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AuthResponse)) {
            return false;
        }
        AuthResponse authResponse = (AuthResponse) o;
        return Objects.equals(access_token, authResponse.access_token) && expires_in == authResponse.expires_in && Objects.equals(token_type, authResponse.token_type) && Objects.equals(scope, authResponse.scope) && Objects.equals(refresh_token, authResponse.refresh_token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(access_token, expires_in, token_type, scope, refresh_token);
    }

    @Override
    public String toString() {
        return "{" +
            " access_token='" + getAccess_token() + "'" +
            ", expires_in='" + getExpires_in() + "'" +
            ", token_type='" + getToken_type() + "'" +
            ", scope='" + getScope() + "'" +
            ", refresh_token='" + getRefresh_token() + "'" +
            "}";
    }

}