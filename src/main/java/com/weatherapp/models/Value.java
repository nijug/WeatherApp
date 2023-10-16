package com.weatherapp.models;

public class Value {

    public String Value;

    public String Unit;

    public int UnitType;

    public String getValue() {
        return Value;
    }

    public String getUnit() {
        return Unit;
    }

    public int getUnitType() {
        return UnitType;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public void setUnitType(int UnitType) {
        this.UnitType = UnitType;
    }
}
