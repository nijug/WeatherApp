package com.weatherapp.models;

public class Country {

        public String ID;
        public String LocalizedName;

        public String EnglishName;

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
