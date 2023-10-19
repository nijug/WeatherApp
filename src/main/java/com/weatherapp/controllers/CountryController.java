package com.weatherapp.controllers;

import com.weatherapp.models.Country;

public class CountryController {

    private String IDs[];

    private String LocalizedNames[];

    private int numberOfCountries;



    public CountryController(Country[] countries) {
        numberOfCountries = countries.length;

        LocalizedNames = new String[numberOfCountries];
        IDs = new String[numberOfCountries];
        for (int i = 0; i < countries.length; i++) {
            LocalizedNames[i] = countries[i].getLocalizedName();
            IDs[i] = countries[i].getID();
        }
    }

   public String getLocalizedName(int index){
        if (index == numberOfCountries) {
            throw new IndexOutOfBoundsException();
        }
        return LocalizedNames[index];
   }

   public String getID(int index) {
       if (index == numberOfCountries) {
           throw new IndexOutOfBoundsException();
       }
       return IDs[index];
   }
    public int getNumberOfCountries() {
        return numberOfCountries;
    }

}


