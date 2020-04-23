package com.eduk8s.hub.model.eduk8s;

import java.util.Objects;

public class Eduk8sPortal {
    private String name;
    private String url;


    public Eduk8sPortal() {
    }

    public Eduk8sPortal(String name, String url) {
        this.name = name;
        this.url = url;
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

    public Eduk8sPortal name(String name) {
        this.name = name;
        return this;
    }

    public Eduk8sPortal url(String url) {
        this.url = url;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Eduk8sPortal)) {
            return false;
        }
        Eduk8sPortal eduk8sPortal = (Eduk8sPortal) o;
        return Objects.equals(name, eduk8sPortal.name) && Objects.equals(url, eduk8sPortal.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }

}