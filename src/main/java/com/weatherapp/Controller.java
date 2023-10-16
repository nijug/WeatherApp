package com.weatherapp;

import com.weatherapp.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    public Button getCurrentTemperatureButton;
    @FXML
    public Label currentCityLabel;
    @FXML
    public Label currentTempLabel;
    @FXML
    public Button getDailyForecastButton;
    @FXML
    public Label minTempLabel;
    @FXML
    public Label minCityLabel;
    @FXML
    public Label maxCityLabel;
    @FXML
    public Label maxTempLabel;
    @FXML
    public ListView<String> regionsList;
    public Label adminAreaLabel;
    @FXML
    private TextField cityField;
    @FXML
    private ListView autocompleteList;

    private boolean isRegionSelected = false;
    private final WeatherAppService service;

    private City[] cities;

    private Region[] regions;

    private Country[] countries;

    private String citySelectedKey;

    private String citySelected;
    public Controller(){
        service = new WeatherAppService();

    }
    @FXML
    public void initialize() {
        regions = service.getRegions();
        for (Region region : regions)
            regionsList.getItems().add(region.getLocalizedName());
    }

    @FXML
    private void onGetCurrentTemperatureClick(ActionEvent e) {
        currentCityLabel.setText(citySelected);
        currentTempLabel.setText(Double.toString(service.getCurrentCondtion(citySelectedKey).Temperature.getMetric().getValue()));

    }

    @FXML
    private void onGetDailyForecastClick(ActionEvent e) {

        DailyForecasts forecast = service.getOneDayForecast(citySelectedKey).getDailyForecasts();
        maxCityLabel.setText(citySelected);
        maxTempLabel.setText(forecast.getTemperature().getMaximum().getValue()+" "+forecast.getTemperature().getMaximum().getUnit());

        minCityLabel.setText(citySelected);
        minTempLabel.setText(forecast.getTemperature().getMinimum().getValue()+" "+forecast.getTemperature().getMinimum().getUnit());

    }
    @FXML
    private void onCityFieldEnter(ActionEvent e) {
        String cityEntered = cityField.getText();
        cities = service.getLocations(cityEntered);
        updateAutocompleteList();

    }

    private void updateAutocompleteList(){
        autocompleteList.getItems().clear();
        for (City city : cities)
            autocompleteList.getItems().add(city.getLocalizedName()+" "+city.getAdministrativeArea().getLocalizedName());
    }

    @FXML
    private void onAutocompleteListClick(MouseEvent e) {
        citySelected = autocompleteList.getSelectionModel().getSelectedItem().toString();
        for (City city : cities) {
            if ((city.getLocalizedName() + " " + city.getAdministrativeArea().getLocalizedName()).equals(citySelected)) {
               citySelectedKey = city.getKey();
            }
        }
    }

    @FXML
    private void onRegionsListClick(MouseEvent e) {
        if (isRegionSelected) {
            String countrySelected = regionsList.getSelectionModel().getSelectedItem();
            for (Country country : countries) {
                if (country.getLocalizedName().equals(countrySelected)) {
                    AdministrativeArea adminArea[] = service.getAdminArea(country.getID());
                    StringBuffer sb = new StringBuffer();
                    for (AdministrativeArea area : adminArea) {
                        sb.append(area.getLocalizedName()+", ");
                    }
                    sb.delete(sb.length()-2, sb.length());
                    adminAreaLabel.setText(sb.toString());
                }
            }
        } else {
            isRegionSelected = true;
            String regionSelected = regionsList.getSelectionModel().getSelectedItem();
            for (Region region : regions) {
                if (region.getLocalizedName().equals(regionSelected)) {
                    regionsList.getItems().clear();
                    countries = service.getCountries(region.getID());
                    for (Country country : countries) {
                        regionsList.getItems().add(country.getLocalizedName());
                    }
                }
            }
        }
    }
}
