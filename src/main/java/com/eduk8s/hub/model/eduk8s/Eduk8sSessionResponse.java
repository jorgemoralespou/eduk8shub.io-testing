package com.eduk8s.hub.model.eduk8s;

import java.util.Objects;

public class Eduk8sSessionResponse {
    private String session;
    private String url;


    public Eduk8sSessionResponse() {
    }

    public Eduk8sSessionResponse(String session, String url) {
        this.session = session;
        this.url = url;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Eduk8sSessionResponse session(String session) {
        this.session = session;
        return this;
    }

    public Eduk8sSessionResponse url(String url) {
        this.url = url;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Eduk8sSessionResponse)) {
            return false;
        }
        Eduk8sSessionResponse eduk8sSessionResponse = (Eduk8sSessionResponse) o;
        return Objects.equals(session, eduk8sSessionResponse.session) && Objects.equals(url, eduk8sSessionResponse.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(session, url);
    }

    @Override
    public String toString() {
        return "{" +
            " session='" + getSession() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }

}