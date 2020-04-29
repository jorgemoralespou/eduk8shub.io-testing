package com.eduk8s.hub.model.hub;

import java.util.Objects;

import com.eduk8s.hub.model.eduk8s.Eduk8sContent;

public class WorkshopContents {
    private String image;
    private String files;


    public WorkshopContents() {
    }

    public WorkshopContents(String image, String files) {
        this.image = image;
        this.files = files;
    }

    public WorkshopContents(Eduk8sContent content) {
        this.image = content.getImage();
        this.files = content.getFiles();
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFiles() {
        return this.files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public WorkshopContents image(String image) {
        this.image = image;
        return this;
    }

    public WorkshopContents files(String files) {
        this.files = files;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WorkshopContents)) {
            return false;
        }
        WorkshopContents workshopContents = (WorkshopContents) o;
        return Objects.equals(image, workshopContents.image) && Objects.equals(files, workshopContents.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, files);
    }

    @Override
    public String toString() {
        return "{" +
            " image='" + getImage() + "'" +
            ", files='" + getFiles() + "'" +
            "}";
    }

}