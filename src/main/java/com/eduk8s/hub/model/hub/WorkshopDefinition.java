package com.eduk8s.hub.model.hub;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import com.eduk8s.hub.model.eduk8s.Eduk8sContent;
import com.eduk8s.hub.model.eduk8s.Eduk8sWorkshop;

public class WorkshopDefinition {
    private WorkshopUID uid;
    private String name;
    private String title;
    private String description;

    public String vendor;
    public String[] authors;
    public String difficulty;
    public String duration;
    public String[] tags;
    public Logo logo;
    public String url;
    public WorkshopContents content;

    private String longDescription = "This is a long description";

    // I made these up
//    private String[] tags = {"basic","intermediate"};
//    private String[] categories = {"containers","jypyter", "ide"};

    private static final List<String> images = Arrays.asList("oci.png", "buildpacks.png", "jupyter.png", "eduk8s.png", "k14s.png");


    private static String randomItem(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }


    public WorkshopDefinition() {
    }

    public WorkshopDefinition(Eduk8sWorkshop workshop){
        uid = new WorkshopUID(workshop.getContent());
        this.name = workshop.getName();
        this.title = workshop.getTitle();
        this.description = workshop.getDescription();
        this.vendor = workshop.getVendor();
        this.authors = workshop.getAuthors();
        this.difficulty = workshop.getDifficulty();
        this.duration = workshop.getDuration();
        this.tags = workshop.getTags();
        this.logo = (workshop.getLogo()==null || "".equals(workshop.getLogo()))? new Logo(WorkshopDefinition.randomItem(images), false): new Logo(workshop.getLogo(), true);
        this.url = workshop.getUrl();
        this.content = new WorkshopContents(workshop.getContent());
        this.longDescription = "This is the long description of the content that has to come from the backend. (WIP). " + workshop.getDescription();
    }

    public WorkshopDefinition(String name, String title, String description, String vendor, String[] authors, String difficulty, String duration, String[] tags, String logo, String url, Eduk8sContent content, String longDescription) {
        this.uid = new WorkshopUID(content);
        this.name = name;
        this.title = title;
        this.description = description;
        this.vendor = vendor;
        this.authors = authors;
        this.difficulty = difficulty;
        this.duration = duration;
        this.tags = tags;
        // TODO: Verify the logo
        this.logo = new Logo(logo, true);
        this.url = url;
        this.content = new WorkshopContents(content);
        this.longDescription = longDescription;
    }

    public WorkshopUID getUid() {
        return this.uid;
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

    public Logo getLogo() {
        return this.logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WorkshopContents getContent() {
        return this.content;
    }

    public void setContent(WorkshopContents content) {
        this.content = content;
    }

    public String getLongDescription() {
        return this.longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public WorkshopDefinition name(String name) {
        this.name = name;
        return this;
    }

    public WorkshopDefinition title(String title) {
        this.title = title;
        return this;
    }

    public WorkshopDefinition description(String description) {
        this.description = description;
        return this;
    }

    public WorkshopDefinition vendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public WorkshopDefinition authors(String[] authors) {
        this.authors = authors;
        return this;
    }

    public WorkshopDefinition difficulty(String difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public WorkshopDefinition duration(String duration) {
        this.duration = duration;
        return this;
    }

    public WorkshopDefinition tags(String[] tags) {
        this.tags = tags;
        return this;
    }

    public WorkshopDefinition logo(Logo logo) {
        this.logo = logo;
        return this;
    }

    public WorkshopDefinition url(String url) {
        this.url = url;
        return this;
    }

    public WorkshopDefinition content(WorkshopContents content) {
        this.content = content;
        return this;
    }

    public WorkshopDefinition longDescription(String longDescription) {
        this.longDescription = longDescription;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WorkshopDefinition)) {
            return false;
        }
        // TODO: Should workshops only be the same on same UID?
        WorkshopDefinition workshopDefinition = (WorkshopDefinition) o;
        return Objects.equals(name, workshopDefinition.name) && 
               Objects.equals(title, workshopDefinition.title) && 
//               Objects.equals(description, workshopDefinition.description) && 
//               Objects.equals(vendor, workshopDefinition.vendor) && 
//               Objects.equals(authors, workshopDefinition.authors) && 
//               Objects.equals(difficulty, workshopDefinition.difficulty) && 
//               Objects.equals(duration, workshopDefinition.duration) && 
//               Objects.equals(tags, workshopDefinition.tags) && 
//               Objects.equals(logo, workshopDefinition.logo) && 
//               Objects.equals(url, workshopDefinition.url) && 
//               Objects.equals(image, workshopDefinition.image) && 
               Objects.equals(content, workshopDefinition.content) // && 
//               Objects.equals(longDescription, workshopDefinition.longDescription)
;
    }

    @Override
    public int hashCode() {
        // TODO: Should workshops only be the same on same UID?
        return Objects.hash(name, title, content);
//        return Objects.hash(name, title, description, vendor, authors, difficulty, duration, tags, logo, url, image, content, longDescription);
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
            ", content='" + getContent() + "'" +
            ", longDescription='" + getLongDescription() + "'" +
            "}";
    }

}