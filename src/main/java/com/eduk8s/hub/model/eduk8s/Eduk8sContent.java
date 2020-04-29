package com.eduk8s.hub.model.eduk8s;

import java.util.Objects;

public class Eduk8sContent {
    private String image;
    private String files;


    public Eduk8sContent() {
    }

    public Eduk8sContent(String image, String files) {
        this.image = image;
        this.files = files;
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

    public Eduk8sContent image(String image) {
        this.image = image;
        return this;
    }

    public Eduk8sContent files(String files) {
        this.files = files;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Eduk8sContent)) {
            return false;
        }
        Eduk8sContent eduk8sContent = (Eduk8sContent) o;
        return Objects.equals(image, eduk8sContent.image) && Objects.equals(files, eduk8sContent.files);
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