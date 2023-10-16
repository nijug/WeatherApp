package com.weatherapp.models;

public class AdministrativeArea {

    public String ID;
    public String LocalizedName;

    public String EnglishName;

    public int Level;

    public String LocalizedType;

    public String EnglishType;

    public String CountryID;


    public int getLevel() {
        return Level;
    }

    public String getLocalizedType() {
        return LocalizedType;
    }

    public String getEnglishType() {
        return EnglishType;
    }

    public String getCountryID() {
        return CountryID;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public void setLocalizedType(String LocalizedType) {
        this.LocalizedType = LocalizedType;
    }

    public void setEnglishType(String EnglishType) {
        this.EnglishType = EnglishType;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public void setEnglishName(String EnglishName) {
        this.EnglishName = EnglishName;
    }

    public String getID() {
        return ID;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public void setLocalizedName(String LocalizedName) {
        this.LocalizedName = LocalizedName;
    }
}
