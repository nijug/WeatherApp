package com.weatherapp.models;

public class Imperial {

        public double Value;
        public String Unit;
        public int UnitType;

        public double getValue() {
            return Value;
        }

        public String getUnit() {
            return Unit;
        }

        public int getUnitType() {
            return UnitType;
        }

        public void setValue(double Value) {
            this.Value = Value;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public void setUnitType(int UnitType) {
            this.UnitType = UnitType;
        }
}
