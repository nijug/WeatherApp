module com.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    opens com.weatherapp to javafx.fxml, com.fasterxml.jackson.databind;
    exports com.weatherapp;
    exports com.weatherapp.models;
    exports com.weatherapp.controllers;
    opens com.weatherapp.controllers to com.fasterxml.jackson.databind, javafx.fxml;
    exports com.weatherapp.services;
    opens com.weatherapp.services to com.fasterxml.jackson.databind, javafx.fxml;
}