package com.weatherapp.models;


public class City {

    public int Version;

    public String Key;

    public String Type;

    public int Rank;

    public String LocalizedName;

    public Country Country;
    public AdministrativeArea AdministrativeArea;

    public String getKey() {
            return Key;
    }

    public String getLocalizedName() {
            return LocalizedName;
    }

    public AdministrativeArea getAdministrativeArea() {
            return AdministrativeArea;
    }

    public void setKey(String Key) {
            this.Key = Key;
    }

    public void setLocalizedName(String LocalizedName) {
            this.LocalizedName = LocalizedName;
    }

    public void setAdministrativeArea(AdministrativeArea AdministrativeArea) {
            this.AdministrativeArea = AdministrativeArea;
    }
    public void setVersion(int Version) {
            this.Version = Version;
    }

    public void setType(String Type) {
            this.Type = Type;
    }


    public void setRank(int Rank) {
          this.Rank = Rank;
    }

    public void setCountry(Country Country) {
            this.Country = Country;
    }

    public int getVersion() {
        return Version;
    }

    public String getType() {
        return Type;
    }

    public int getRank() {
        return Rank;
    }

    public Country getCountry() {
        return Country;
    }
}
