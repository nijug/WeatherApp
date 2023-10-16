package com.weatherapp.models;

public class Temperature {

            public Imperial Imperial;
            public Metric Metric;
            public Value Minimum;
            public Value Maximum;

            public Value getMinimum() {
                return Minimum;
            }

            public Value getMaximum() {
                return Maximum;
            }

            public void setMinimum(Value Minimum) {
                this.Minimum = Minimum;
            }

            public void setMaximum(Value Maximum) {
                this.Maximum = Maximum;
            }

            public Imperial getImperial() {
                return Imperial;
            }

            public Metric getMetric() {
                return Metric;
            }

            public void setImperial(Imperial Imperial) {
                this.Imperial = Imperial;
            }

            public void setMetric(Metric Metric) {
                this.Metric = Metric;
            }
}
