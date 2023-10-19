package com.weatherapp.controllers;

import com.weatherapp.services.WeatherAppService;
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

    private CityController cities;

    private RegionController regions;

    private CountryController countries;

    public Controller(){
        service = new WeatherAppService();

    }
    @FXML
    public void initialize() {
        regions = new RegionController(service.getRegions());
        for (int i = 0; i < regions.getNumberOfRegions(); i++) {
            regionsList.getItems().add(regions.getLocalizedName(i));
        }
    }

    @FXML
    private void onGetCurrentTemperatureClick(ActionEvent e) {
        currentCityLabel.setText(cities.getLocalizedName(cities.getCitySelectedIndex()));
        currentTempLabel.setText(Double.toString(service.getCurrentCondtion(cities.getKey(cities.getCitySelectedIndex())).Temperature.getMetric().getValue()));

    }

    @FXML
    private void onGetDailyForecastClick(ActionEvent e) {

        DailyForecasts forecast = service.getOneDayForecast(cities.getKey(cities.getCitySelectedIndex())).getDailyForecasts();
        maxCityLabel.setText(cities.getLocalizedName(cities.getCitySelectedIndex()));
        maxTempLabel.setText(forecast.getTemperature().getMaximum().getValue()+" "+forecast.getTemperature().getMaximum().getUnit());

        minCityLabel.setText(cities.getLocalizedName(cities.getCitySelectedIndex()));
        minTempLabel.setText(forecast.getTemperature().getMinimum().getValue()+" "+forecast.getTemperature().getMinimum().getUnit());

    }
    @FXML
    private void onCityFieldEnter(ActionEvent e) {
        String cityEntered = cityField.getText();

        cities = new CityController(service.getLocations(cityEntered));
        updateAutocompleteList();

    }

    private void updateAutocompleteList() {
        autocompleteList.getItems().clear();
        for (int i = 0; i < cities.getNumberOfCities(); i++) {
            autocompleteList.getItems().add(cities.getLocalizedName(i) + " " + cities.getAdministrativeAreasNames(i));
        }
    }
    @FXML
    private void onAutocompleteListClick(MouseEvent e) {
        String citySelected = autocompleteList.getSelectionModel().getSelectedItem().toString();
        for (int i = 0; i < cities.getNumberOfCities(); i++) {
            if ((cities.getLocalizedName(i) + " " + cities.getAdministrativeAreasNames(i)).equals(citySelected)) {
                cities.setCitySelectedIndex(i);
            }
        }
    }

    @FXML
    private void onRegionsListClick(MouseEvent e) {
        if (isRegionSelected) {
            System.out.println("Country selected");
            String countrySelected = regionsList.getSelectionModel().getSelectedItem();
            for (int i = 0; i < countries.getNumberOfCountries(); i++)
                if  (countries.getLocalizedName(i).equals(countrySelected)) {
                    AdministrativeArea adminArea[] = service.getAdminArea(countries.getID(i));
                    StringBuffer sb = new StringBuffer();
                    for (AdministrativeArea area : adminArea) {
                        sb.append(area.getLocalizedName()+", ");
                    }
                    sb.delete(sb.length()-2, sb.length());
                    adminAreaLabel.setText(sb.toString());
                }
        } else {
            System.out.println("Region selected");
            isRegionSelected = true;
            String regionSelected = regionsList.getSelectionModel().getSelectedItem();
            for ( int i = 0; i < regions.getNumberOfRegions(); i++) {
                if (regions.getLocalizedName(i).equals(regionSelected)) {
                    regionsList.getItems().clear();
                    countries = new CountryController(service.getCountries(regions.getID(i)));
                    for(int j = 0; j < countries.getNumberOfCountries(); j++){
                        regionsList.getItems().add(countries.getLocalizedName(j));
                    }
                }
            }
        }
    }
}
