package com.eduk8s.hub.model.hub;

import java.util.Base64;
import java.util.Objects;

import com.eduk8s.hub.model.eduk8s.Eduk8sContent;

public class WorkshopUID {

    private String image;
    private String files;

    private String encodedUID;

    private WorkshopUID(String workshopUID) {
        this.encodedUID = workshopUID;
    }

    public WorkshopUID(Eduk8sContent content) {
        this.image = content.getImage();
        this.files = content.getFiles();
        String compound = this.image + this.files;
        this.encodedUID = Base64.getEncoder().encodeToString(compound.getBytes());
    }

    public WorkshopUID(String image, String files) {
        this.image = image;
        this.files = files;
        String compound = this.image + this.files;
        this.encodedUID = Base64.getEncoder().encodeToString(compound.getBytes());
    }

    public WorkshopUID(WorkshopDefinition workshopDef) {
        this.image = workshopDef.getContent().getImage();
        this.files = workshopDef.getContent().getFiles();
        String compound = this.image + this.files;
        this.encodedUID = Base64.getEncoder().encodeToString(compound.getBytes());
    }

    public static WorkshopUID fromString(String workshopUID){
        return new WorkshopUID(workshopUID);
    }

    public String getImage() {
        return image;
    }

    public String getFiles() {
        return files;
    }

    public String getEncodedUID() {
        return encodedUID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WorkshopUID)) {
            return false;
        }
        WorkshopUID workshopUID = (WorkshopUID) o;
        return Objects.equals(encodedUID, workshopUID.encodedUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(encodedUID);
    }

    @Override
    public String toString() {
        return "{" +
            " uid='" + encodedUID + "'" +
            ", image='" + image + "'" +
            ", files='" + files + "'" +
            "}";
    }


    public static void main(String[] args) {
        WorkshopUID ui1 = new WorkshopUID("image", "content");
        WorkshopUID ui2 = new WorkshopUID("image", "content");
        WorkshopUID ui3 = new WorkshopUID("image1", "content");
        WorkshopUID ui4 = new WorkshopUID("image", "content1");
        WorkshopUID ui5 = new WorkshopUID("image1", "content1");


        System.out.println("ui1: " + ui1);
        System.out.println("ui2: " + ui1);
        System.out.println("ui3: " + ui1);
        System.out.println("ui4: " + ui1);
        System.out.println("ui5: " + ui1);

        System.out.println("ui1 = ui1: " + (ui1.equals(ui1)));
        System.out.println("ui1 = ui2: " + (ui1.equals(ui2)));
        System.out.println("ui1 = ui3: " + (ui1.equals(ui3)));
        System.out.println("ui1 = ui4: " + (ui1.equals(ui4)));
        System.out.println("ui1 = ui5: " + (ui1.equals(ui5)));

        System.out.println("ui1 hash: " + (ui1.hashCode()));
        System.out.println("ui2 hash: " + (ui2.hashCode()));
        System.out.println("ui3 hash: " + (ui3.hashCode()));
        System.out.println("ui4 hash: " + (ui4.hashCode()));
        System.out.println("ui5 hash: " + (ui5.hashCode()));
    }

}