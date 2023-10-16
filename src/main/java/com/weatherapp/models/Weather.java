package com.weatherapp.models;

import java.util.Date;

public class Weather {

        public Date LocalObservationDateTime;

        public int EpochTime;
        public String WeatherText;

        public int WeatherIcon;

        public boolean HasPrecipitation;

        public Object PrecipitationType;

        public boolean IsDayTime;
        public Temperature Temperature;
        public String MobileLink;
        public String Link;

        public Date getLocalObservationDateTime() {
            return LocalObservationDateTime;
        }

        public String getWeatherText() {
            return WeatherText;
        }

        public Temperature getTemperature() {
            return Temperature;
        }

        public String getMobileLink() {
            return MobileLink;
        }

        public String getLink() {
            return Link;
        }

        public void setLocalObservationDateTime(Date LocalObservationDateTime) {
            this.LocalObservationDateTime = LocalObservationDateTime;
        }

        public void setWeatherText(String WeatherText) {
            this.WeatherText = WeatherText;
        }

        public void setTemperature(Temperature Temperature) {
            this.Temperature = Temperature;
        }

        public void setMobileLink(String MobileLink) {
            this.MobileLink = MobileLink;
        }

        public void setLink(String Link) {
            this.Link = Link;
        }

        public int getEpochTime() {
            return EpochTime;
        }

        public void setEpochTime(int EpochTime) {
            this.EpochTime = EpochTime;
        }

        public int getWeatherIcon() {
            return WeatherIcon;
        }

        public void setWeatherIcon(int WeatherIcon) {
            this.WeatherIcon = WeatherIcon;
        }

        public boolean getHasPrecipitation() {
            return HasPrecipitation;
        }

        public void setHasPrecipitation(boolean HasPrecipitation) {
            this.HasPrecipitation = HasPrecipitation;
        }

        public Object getPrecipitationType() {
            return PrecipitationType;
        }

        public void setPrecipitationType(Object PrecipitationType) {
            this.PrecipitationType = PrecipitationType;
        }

        public boolean getIsDayTime() {
            return IsDayTime;
        }

        public void setIsDayTime(boolean IsDayTime) {
            this.IsDayTime = IsDayTime;
        }


}
