package com.eduk8s.hub.model.eduk8s;

import java.util.Objects;

public class Eduk8sEnvironment {
    public String name;
    public Eduk8sWorkshop workshop;
    public int duration;
    public int capacity;
    public int reserved;
    public int allocated;
    public int available;


    public Eduk8sEnvironment() {
    }

    public Eduk8sEnvironment(String name, Eduk8sWorkshop workshop, int duration, int capacity, int reserved, int allocated, int available) {
        this.name = name;
        this.workshop = workshop;
        this.duration = duration;
        this.capacity = capacity;
        this.reserved = reserved;
        this.allocated = allocated;
        this.available = available;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Eduk8sWorkshop getWorkshop() {
        return this.workshop;
    }

    public void setWorkshop(Eduk8sWorkshop workshop) {
        this.workshop = workshop;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getReserved() {
        return this.reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public int getAllocated() {
        return this.allocated;
    }

    public void setAllocated(int allocated) {
        this.allocated = allocated;
    }

    public int getAvailable() {
        return this.available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public Eduk8sEnvironment name(String name) {
        this.name = name;
        return this;
    }

    public Eduk8sEnvironment workshop(Eduk8sWorkshop workshop) {
        this.workshop = workshop;
        return this;
    }

    public Eduk8sEnvironment duration(int duration) {
        this.duration = duration;
        return this;
    }

    public Eduk8sEnvironment capacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Eduk8sEnvironment reserved(int reserved) {
        this.reserved = reserved;
        return this;
    }

    public Eduk8sEnvironment allocated(int allocated) {
        this.allocated = allocated;
        return this;
    }

    public Eduk8sEnvironment available(int available) {
        this.available = available;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Eduk8sEnvironment)) {
            return false;
        }
        Eduk8sEnvironment eduk8sEnvironment = (Eduk8sEnvironment) o;
        return Objects.equals(name, eduk8sEnvironment.name) && Objects.equals(workshop, eduk8sEnvironment.workshop) && duration == eduk8sEnvironment.duration && capacity == eduk8sEnvironment.capacity && reserved == eduk8sEnvironment.reserved && allocated == eduk8sEnvironment.allocated && available == eduk8sEnvironment.available;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, workshop, duration, capacity, reserved, allocated, available);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", workshop='" + getWorkshop() + "'" +
            ", duration='" + getDuration() + "'" +
            ", capacity='" + getCapacity() + "'" +
            ", reserved='" + getReserved() + "'" +
            ", allocated='" + getAllocated() + "'" +
            ", available='" + getAvailable() + "'" +
            "}";
    }

}