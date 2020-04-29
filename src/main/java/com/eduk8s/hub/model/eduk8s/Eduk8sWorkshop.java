package com.eduk8s.hub.model.eduk8s;

import java.util.Objects;

public class Eduk8sWorkshop {
    public String name;
    public String title;
    public String description;
    public String vendor;
    public String[] authors;
    public String difficulty;
    public String duration;
    public String[] tags;
    public String logo;
    public String url;
    public String image;
    public Eduk8sContent content;

    public Eduk8sWorkshop() {
    }

    public Eduk8sWorkshop(String name, String title, String description, String vendor, String[] authors, String difficulty, String duration, String[] tags, String logo, String url, String image, Eduk8sContent content) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.vendor = vendor;
        this.authors = authors;
        this.difficulty = difficulty;
        this.duration = duration;
        this.tags = tags;
        this.logo = logo;
        this.url = url;
        this.image = image;
        this.content = content;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String[] getAuthors() {
        return this.authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String[] getTags() {
        return this.tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Eduk8sContent getContent() {
        return this.content;
    }

    public void setContent(Eduk8sContent content) {
        this.content = content;
    }

    public Eduk8sWorkshop name(String name) {
        this.name = name;
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

    public Eduk8sWorkshop vendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public Eduk8sWorkshop authors(String[] authors) {
        this.authors = authors;
        return this;
    }

    public Eduk8sWorkshop difficulty(String difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public Eduk8sWorkshop duration(String duration) {
        this.duration = duration;
        return this;
    }

    public Eduk8sWorkshop tags(String[] tags) {
        this.tags = tags;
        return this;
    }

    public Eduk8sWorkshop logo(String logo) {
        this.logo = logo;
        return this;
    }

    public Eduk8sWorkshop url(String url) {
        this.url = url;
        return this;
    }

    public Eduk8sWorkshop image(String image) {
        this.image = image;
        return this;
    }

    public Eduk8sWorkshop content(Eduk8sContent content) {
        this.content = content;
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
        return Objects.equals(name, eduk8sWorkshop.name) && Objects.equals(title, eduk8sWorkshop.title) && Objects.equals(description, eduk8sWorkshop.description) && Objects.equals(vendor, eduk8sWorkshop.vendor) && Objects.equals(authors, eduk8sWorkshop.authors) && Objects.equals(difficulty, eduk8sWorkshop.difficulty) && Objects.equals(duration, eduk8sWorkshop.duration) && Objects.equals(tags, eduk8sWorkshop.tags) && Objects.equals(logo, eduk8sWorkshop.logo) && Objects.equals(url, eduk8sWorkshop.url) && Objects.equals(image, eduk8sWorkshop.image) && Objects.equals(content, eduk8sWorkshop.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, title, description, vendor, authors, difficulty, duration, tags, logo, url, image, content);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", vendor='" + getVendor() + "'" +
            ", authors='" + getAuthors() + "'" +
            ", difficulty='" + getDifficulty() + "'" +
            ", duration='" + getDuration() + "'" +
            ", tags='" + getTags() + "'" +
            ", logo='" + getLogo() + "'" +
            ", url='" + getUrl() + "'" +
            ", image='" + getImage() + "'" +
            ", content='" + getContent() + "'" +
            "}";
    }
}