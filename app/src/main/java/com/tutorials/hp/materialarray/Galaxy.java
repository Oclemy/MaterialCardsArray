package com.tutorials.hp.materialarray;

/**
 - Our data object class
 - Represents a single galaxy with name,description and image.
 - Takes in property values via Constructor.
 - Exposes them via getter methods.
 */

public class Galaxy {
    private String name,description;
    private int image;

    public Galaxy(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

}
