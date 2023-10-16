package com.weatherapp.models;

public class Region {

    public String ID;
    public String LocalizedName;
    public String EnglishName;

    public String getID() {
        return ID;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setLocalizedName(String LocalizedName) {
        this.LocalizedName = LocalizedName;
    }

    public void setEnglishName(String EnglishName) {
        this.EnglishName = EnglishName;
    }
}
