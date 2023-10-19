package com.weatherapp.controllers;

import com.weatherapp.models.AdministrativeArea;
import com.weatherapp.models.City;
public class CityController {

    private String Keys[];

    private String LocalizedNames[];

    private String[] administrativeAreasNames;

    private int numberOfCities;

    private int citySelectedIndex;

    private String citySelectedName;



    public CityController(City[] cities) {
        numberOfCities = cities.length;

        LocalizedNames = new String[numberOfCities];
        Keys = new String[numberOfCities];
        administrativeAreasNames = new String[numberOfCities];
        for (int i = 0; i < cities.length; i++) {
            LocalizedNames[i] = cities[i].getLocalizedName();
            Keys[i] = cities[i].getKey();
            administrativeAreasNames[i] = cities[i].getAdministrativeArea().getLocalizedName();
        }
    }

    public String getLocalizedName(int index){
        if (index == numberOfCities) {
            throw new IndexOutOfBoundsException();
        }
        return LocalizedNames[index];
    }

    public String getKey(int index) {
        if (index == numberOfCities) {
            throw new IndexOutOfBoundsException();
        }
        return Keys[index];
    }
    public int getNumberOfCities() {
        return numberOfCities;
    }

    public String getAdministrativeAreasNames(int index){
        if (index == numberOfCities) {
            throw new IndexOutOfBoundsException();
        }
        return administrativeAreasNames[index];
    }

    public int getCitySelectedIndex() {
        return citySelectedIndex;
    }

    public void setCitySelectedIndex(int citySelectedIndex) {
        this.citySelectedIndex = citySelectedIndex;
    }

}



