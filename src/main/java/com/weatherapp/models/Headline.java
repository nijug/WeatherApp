package com.weatherapp.models;

public class Headline {

    public String EffectiveDate;
    public long EffectiveEpochDate;
    public int Severity;
    public String Text;
    public String Category;
    public String EndDate;
    public long EndEpochDate;
    public String MobileLink;
    public String Link;

    public String getEffectiveDate() {
        return EffectiveDate;
    }

    public long getEffectiveEpochDate() {
        return EffectiveEpochDate;
    }

    public int getSeverity() {
        return Severity;
    }

    public String getText() {
        return Text;
    }

    public String getCategory() {
        return Category;
    }

    public String getEndDate() {
        return EndDate;
    }

    public long getEndEpochDate() {
        return EndEpochDate;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public String getLink() {
        return Link;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.EffectiveDate = effectiveDate;
    }

    public void setEffectiveEpochDate(long effectiveEpochDate) {
        this.EffectiveEpochDate = effectiveEpochDate;
    }

    public void setSeverity(int severity) {
        this.Severity = severity;
    }

    public void setText(String text) {
        this.Text = text;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public void setEndDate(String endDate) {
        this.EndDate = endDate;
    }

    public void setEndEpochDate(long endEpochDate) {
        this.EndEpochDate = endEpochDate;
    }

    public void setMobileLink(String mobileLink) {
        this.MobileLink = mobileLink;
    }

    public void setLink(String link) {
        this.Link = link;
    }
}