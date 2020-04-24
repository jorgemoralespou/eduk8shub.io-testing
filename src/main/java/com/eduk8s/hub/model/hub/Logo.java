package com.eduk8s.hub.model.hub;

import java.util.Objects;

public class Logo {
    private String logo;
    private Boolean dataUri;



    public Logo() {
    }

    public Logo(String logo, Boolean dataUri) {
        this.logo = logo;
        this.dataUri = dataUri;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Boolean isDataUri() {
        return this.dataUri;
    }

    public Boolean getDataUri() {
        return this.dataUri;
    }

    public void setDataUri(Boolean dataUri) {
        this.dataUri = dataUri;
    }

    public Logo logo(String logo) {
        this.logo = logo;
        return this;
    }

    public Logo dataUri(Boolean dataUri) {
        this.dataUri = dataUri;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Logo)) {
            return false;
        }
        Logo logo = (Logo) o;
        return Objects.equals(logo, logo.logo) && Objects.equals(dataUri, logo.dataUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logo, dataUri);
    }

    @Override
    public String toString() {
        return "{" +
            " logo='" + getLogo() + "'" +
            ", dataUri='" + isDataUri() + "'" +
            "}";
    }

}