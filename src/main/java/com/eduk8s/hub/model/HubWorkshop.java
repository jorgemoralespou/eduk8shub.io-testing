package com.eduk8s.hub.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "test", "template" })
public class HubWorkshop {
    public String id;
    public String layout;
    public String title;
    public List<String> categories;
    public List<String> tags;
    public String img;
    public String githuburl;
    public String duration;
    public String author;
    public String install;
    public String install_notes;
    public String delete;
    public String delete_notes;
    public String example;
    public String href;
    public String content;

    public HubWorkshop(){
    }

    public HubWorkshop(String id, String layout, String title, List<String> categories, List<String> tags, String img, String githuburl, String duration, String author, String install, String install_notes, String delete, String delete_notes, String example, String href, String content) {
        this.id = id;
        this.layout = layout;
        this.title = title;
        this.categories = categories;
        this.tags = tags;
        this.img = img;
        this.githuburl = githuburl;
        this.duration = duration;
        this.author = author;
        this.install = install;
        this.install_notes = install_notes;
        this.delete = delete;
        this.delete_notes = delete_notes;
        this.example = example;
        this.href = href;
        this.content = content;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLayout() {
        return this.layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCategories() {
        return this.categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void addCategory(String category) {
        if (this.categories==null)
            this.categories = new ArrayList<String>();
        categories.add(category);
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void addTag(String tag) {
        if (this.tags==null)
            this.tags = new ArrayList<String>();
        tags.add(tag);
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGithuburl() {
        return this.githuburl;
    }

    public void setGithuburl(String githuburl) {
        this.githuburl = githuburl;
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

    public String getInstall() {
        return this.install;
    }

    public void setInstall(String install) {
        this.install = install;
    }

    public String getInstall_notes() {
        return this.install_notes;
    }

    public void setInstall_notes(String install_notes) {
        this.install_notes = install_notes;
    }

    public String getDelete() {
        return this.delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getDelete_notes() {
        return this.delete_notes;
    }

    public void setDelete_notes(String delete_notes) {
        this.delete_notes = delete_notes;
    }

    public String getExample() {
        return this.example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HubWorkshop id(String id) {
        this.id = id;
        return this;
    }

    public HubWorkshop layout(String layout) {
        this.layout = layout;
        return this;
    }

    public HubWorkshop title(String title) {
        this.title = title;
        return this;
    }

    public HubWorkshop categories(List<String> categories) {
        this.categories = categories;
        return this;
    }

    public HubWorkshop tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public HubWorkshop img(String img) {
        this.img = img;
        return this;
    }

    public HubWorkshop githuburl(String githuburl) {
        this.githuburl = githuburl;
        return this;
    }

    public HubWorkshop duration(String duration) {
        this.duration = duration;
        return this;
    }

    public HubWorkshop author(String author) {
        this.author = author;
        return this;
    }

    public HubWorkshop install(String install) {
        this.install = install;
        return this;
    }

    public HubWorkshop install_notes(String install_notes) {
        this.install_notes = install_notes;
        return this;
    }

    public HubWorkshop delete(String delete) {
        this.delete = delete;
        return this;
    }

    public HubWorkshop delete_notes(String delete_notes) {
        this.delete_notes = delete_notes;
        return this;
    }

    public HubWorkshop example(String example) {
        this.example = example;
        return this;
    }

    public HubWorkshop href(String href) {
        this.href = href;
        return this;
    }

    public HubWorkshop content(String content) {
        this.content = content;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HubWorkshop)) {
            return false;
        }
        HubWorkshop hubWorkshop = (HubWorkshop) o;
        return Objects.equals(id, hubWorkshop.id) && Objects.equals(layout, hubWorkshop.layout) && Objects.equals(title, hubWorkshop.title) && Objects.equals(categories, hubWorkshop.categories) && Objects.equals(tags, hubWorkshop.tags) && Objects.equals(img, hubWorkshop.img) && Objects.equals(githuburl, hubWorkshop.githuburl) && Objects.equals(duration, hubWorkshop.duration) && Objects.equals(author, hubWorkshop.author) && Objects.equals(install, hubWorkshop.install) && Objects.equals(install_notes, hubWorkshop.install_notes) && Objects.equals(delete, hubWorkshop.delete) && Objects.equals(delete_notes, hubWorkshop.delete_notes) && Objects.equals(example, hubWorkshop.example) && Objects.equals(href, hubWorkshop.href) && Objects.equals(content, hubWorkshop.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, layout, title, categories, tags, img, githuburl, duration, author, install, install_notes, delete, delete_notes, example, href, content);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", layout='" + getLayout() + "'" +
            ", title='" + getTitle() + "'" +
            ", categories='" + getCategories() + "'" +
            ", tags='" + getTags() + "'" +
            ", img='" + getImg() + "'" +
            ", githuburl='" + getGithuburl() + "'" +
            ", duration='" + getDuration() + "'" +
            ", author='" + getAuthor() + "'" +
            ", install='" + getInstall() + "'" +
            ", install_notes='" + getInstall_notes() + "'" +
            ", delete='" + getDelete() + "'" +
            ", delete_notes='" + getDelete_notes() + "'" +
            ", example='" + getExample() + "'" +
            ", href='" + getHref() + "'" +
            ", content='" + getContent() + "'" +
            "}";
    }


}