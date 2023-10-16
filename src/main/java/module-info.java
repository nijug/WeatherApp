module com.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    opens com.weatherapp to javafx.fxml, com.fasterxml.jackson.databind;
    exports com.weatherapp;
    exports com.weatherapp.models;
}