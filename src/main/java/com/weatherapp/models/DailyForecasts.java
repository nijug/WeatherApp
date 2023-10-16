package com.weatherapp.models;

import java.util.List;

public class DailyForecasts {
    public String Date;

    public long EpochDate;
    public Temperature Temperature;
    public Day Day;
    public Night Night;

    public List<String> Sources;
    public String Link;
    public String MobileLink;

    public String getDate() {
        return Date;
    }

    public Temperature getTemperature() {
        return Temperature;
    }

    public Day getDay() {
        return Day;
    }

    public Night getNight() {
        return Night;
    }

    public long getEpochDate() {
        return EpochDate;
    }

    public String getLink() {
        return Link;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setTemperature(Temperature Temperature) {
        this.Temperature = Temperature;
    }

    public void setDay(Day Day) {
        this.Day = Day;
    }

    public void setNight(Night Night) {
        this.Night = Night;
    }

    public void setEpochDate(long EpochDate) {
        this.EpochDate = EpochDate;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public void setMobileLink(String MobileLink) {
        this.MobileLink = MobileLink;
    }

    public List<String> getSources() {
        return Sources;
    }

    public void setSources(List<String> Sources) {
        this.Sources = Sources;
    }
}
