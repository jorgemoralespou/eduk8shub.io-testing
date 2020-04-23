package com.eduk8s.hub.model.hub;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import com.eduk8s.hub.model.eduk8s.Eduk8sWorkshop;

public class WorkshopDefinition {
    private String name;
    private String vendor;
    private String title;
    private String description;
    private String url;

    // I made these up
    private String id = "_id_";
    private String githuburl = "https://github.com/eduk8s-labs/lab-container-basics";
    private String[] tags = {"basic","intermediate"};
    private String[] categories = {"containers","jypyter", "ide"};
    private String img = randomItem(images);
    private String duration =  randomItem(durations);
    private String author = randomItem(authors);
    private String content = "Example workshop";

    private static final List<String> images = Arrays.asList("oci.png", "buildpacks.png", "jupyter.png", "eduk8s.png", "k14s.png");
    private static final List<String> durations = Arrays.asList("1 hour", "30 minutes", "45 minutes", "10 minutes");
    private static final List<String> authors = Arrays.asList("Jorge", "Graham", "Daniel");


    private static String randomItem(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public WorkshopDefinition() {
    }

    public WorkshopDefinition(Eduk8sWorkshop workshop){
        // Change this to getters, once available
        this.name = workshop.name;
        this.vendor = workshop.vendor;
        this.title = workshop.title;
        this.description = workshop.description;
        this.url = workshop.url;
    }

    public WorkshopDefinition(String name, String vendor, String title, String description, String url, String id, String githuburl, String[] tags, String[] categories, String img, String duration, String author, String content) {
        this.name = name;
        this.vendor = vendor;
        this.title = title;
        this.description = description;
        this.url = url;
        this.id = id;
        this.githuburl = githuburl;
        this.tags = tags;
        this.categories = categories;
        this.img = img;
        this.duration = duration;
        this.author = author;
        this.content = content;
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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGithuburl() {
        return this.githuburl;
    }

    public void setGithuburl(String githuburl) {
        this.githuburl = githuburl;
    }

    public String[] getTags() {
        return this.tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String[] getCategories() {
        return this.categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WorkshopDefinition name(String name) {
        this.name = name;
        return this;
    }

    public WorkshopDefinition vendor(String vendor) {
        this.vendor = vendor;
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

    public WorkshopDefinition url(String url) {
        this.url = url;
        return this;
    }

    public WorkshopDefinition id(String id) {
        this.id = id;
        return this;
    }

    public WorkshopDefinition githuburl(String githuburl) {
        this.githuburl = githuburl;
        return this;
    }

    public WorkshopDefinition tags(String[] tags) {
        this.tags = tags;
        return this;
    }

    public WorkshopDefinition categories(String[] categories) {
        this.categories = categories;
        return this;
    }

    public WorkshopDefinition img(String img) {
        this.img = img;
        return this;
    }

    public WorkshopDefinition duration(String duration) {
        this.duration = duration;
        return this;
    }

    public WorkshopDefinition author(String author) {
        this.author = author;
        return this;
    }

    public WorkshopDefinition content(String content) {
        this.content = content;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WorkshopDefinition)) {
            return false;
        }
        WorkshopDefinition workshopDefinition = (WorkshopDefinition) o;
        return Objects.equals(name, workshopDefinition.name) && 
               Objects.equals(vendor, workshopDefinition.vendor) && 
               Objects.equals(title, workshopDefinition.title) && 
               Objects.equals(description, workshopDefinition.description);
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
            ", id='" + getId() + "'" +
            ", githuburl='" + getGithuburl() + "'" +
            ", tags='" + getTags() + "'" +
            ", categories='" + getCategories() + "'" +
            ", img='" + getImg() + "'" +
            ", duration='" + getDuration() + "'" +
            ", author='" + getAuthor() + "'" +
            ", content='" + getContent() + "'" +
            "}";
    }

}