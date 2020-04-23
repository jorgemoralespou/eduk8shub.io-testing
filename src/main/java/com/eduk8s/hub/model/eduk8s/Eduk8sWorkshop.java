package com.eduk8s.hub.model.eduk8s;

import java.util.Objects;

public class Eduk8sWorkshop {
    public String name;
    public String vendor;
    public String title;
    public String description;
    public String url;


    public Eduk8sWorkshop() {
    }

    public Eduk8sWorkshop(String name, String vendor, String title, String description, String url) {
        this.name = name;
        this.vendor = vendor;
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Eduk8sWorkshop name(String name) {
        this.name = name;
        return this;
    }

    public Eduk8sWorkshop vendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public Eduk8sWorkshop title(String title) {
        this.title = title;
        return this;
    }

    public Eduk8sWorkshop description(String description) {
        this.description = description;
        return this;
    }

    public Eduk8sWorkshop url(String url) {
        this.url = url;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Eduk8sWorkshop)) {
            return false;
        }
        Eduk8sWorkshop eduk8sWorkshop = (Eduk8sWorkshop) o;
        return Objects.equals(name, eduk8sWorkshop.name) && Objects.equals(vendor, eduk8sWorkshop.vendor) && Objects.equals(title, eduk8sWorkshop.title) && Objects.equals(description, eduk8sWorkshop.description) && Objects.equals(url, eduk8sWorkshop.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vendor, title, description, url);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", vendor='" + getVendor() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }

}
