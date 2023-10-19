package com.weatherapp.controllers;

import com.weatherapp.models.Region;

public class RegionController {


    private String IDs[];

    private String LocalizedNames[];

    private int numberOfRegions;


    public RegionController(Region[] regions) {
        numberOfRegions = regions.length;
        LocalizedNames = new String[numberOfRegions];
        IDs = new String[numberOfRegions];

        for (int i = 0; i < regions.length; i++) {
            LocalizedNames[i] = regions[i].getLocalizedName();
            IDs[i] = regions[i].getID();
        }
    }

    public String getLocalizedName(int index){
        if (index == numberOfRegions) {
            throw new IndexOutOfBoundsException();
        }
        return LocalizedNames[index];
    }

    public String getID(int index) {
        if (index == numberOfRegions) {
            throw new IndexOutOfBoundsException();
        }
        return IDs[index];
    }
    public int getNumberOfRegions() {
        return numberOfRegions;
    }
}