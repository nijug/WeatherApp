package com.weatherapp.models;

import java.util.List;

public class WeatherData {

    public Headline Headline;

    public List<DailyForecasts> DailyForecasts;

    public Headline getHeadline() {
        return Headline;
    }

    public DailyForecasts getDailyForecasts() {
        return DailyForecasts.get(0);
    }

    public void setHeadline(Headline Headline) {
        this.Headline = Headline;
    }

    public void setDailyForecasts(List<DailyForecasts> DailyForecasts) {
        this.DailyForecasts = DailyForecasts;
    }

}
