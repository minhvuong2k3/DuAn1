package com.raven.model;

import javax.swing.Icon;

public class ModelName {

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ModelName(String firstName, String lastName, String path) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.path = path;
    }

    public ModelName() {
    }

    private String firstName;
    private String lastName;
    private String path;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
