package com.weatherapp.models;

public class Day {
    public int Icon;
    public String IconPhrase;
    public boolean HasPrecipitation;
    public String PrecipitationType;
    public String PrecipitationIntensity;

    public int getIcon() {
        return Icon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public boolean getHasPrecipitation() {
        return HasPrecipitation;
    }

    public String getPrecipitationType() {
        return PrecipitationType;
    }

    public String getPrecipitationIntensity() {
        return PrecipitationIntensity;
    }

    public void setIcon(int Icon) {
        this.Icon = Icon;
    }

    public void setIconPhrase(String IconPhrase) {
        this.IconPhrase = IconPhrase;
    }

    public void setHasPrecipitation(boolean HasPrecipitation) {
        this.HasPrecipitation = HasPrecipitation;
    }

    public void setPrecipitationType(String PrecipitationType) {
        this.PrecipitationType = PrecipitationType;
    }

    public void setPrecipitationIntensity(String PrecipitationIntensity) {
        this.PrecipitationIntensity = PrecipitationIntensity;
    }
}
