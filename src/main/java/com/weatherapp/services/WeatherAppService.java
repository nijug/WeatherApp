package com.weatherapp.services;

import com.weatherapp.models.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WeatherAppService {

    private static final String url = "http://dataservice.accuweather.com/";
    private static final String autocomplete_endpoint = "locations/v1/cities/autocomplete?apikey=%s&q=%s&language=%s";
    private static final String current_conditions_endpoint = "currentconditions/v1/%s?apikey=%s&language=%s";
    private static final String daily_1day_forecast_endpoint = "forecasts/v1/daily/1day/%s?apikey=%s&language=%s";
    private static final String regions_endpoint = "locations/v1/regions/?apikey=%s&language=%s";
    private static final String countries_endpoint = "locations/v1/countries/%s?apikey=%s&language=%s";
    private static final String admin_ares_endpoint = "/locations/v1/adminareas/%s?apikey=%s&language=%s";




    String api_key;
    String language;

    public WeatherAppService() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/com/weatherapp/appdata.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            AppData appData = objectMapper.readValue(jsonData, AppData.class);
            api_key = appData.getApi_key();
            language = appData.getDefault_language();
        } catch (Exception e) {
            System.out.println("Error while reading JSON file");
            e.printStackTrace();
        }
        System.out.println(api_key + " " + language);
    }

    public City[] getLocations(String location_name_query) {
        try {
            URL uri = new URL(url + String.format(autocomplete_endpoint, api_key, location_name_query, language));
            System.out.println(uri);
            HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(content.toString(), City[].class);

        } catch (IOException e) {
            System.out.println("Error while connecting to the API");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }



    public Weather getCurrentCondtion(String location_key) {
        try {
            URL uri = new URL(url + String.format(current_conditions_endpoint, location_key, api_key, language));
            System.out.println(uri);
            HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            Weather[] weather = mapper.readValue(content.toString(), Weather[].class);
            return weather[0];
        } catch (IOException e) {
            System.out.println("Error while connecting to the API");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public WeatherData getOneDayForecast(String location_key) {
        try {
            URL uri = new URL(url + String.format(daily_1day_forecast_endpoint, location_key ,api_key, language));
            System.out.println(uri);
            HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            WeatherData daily = mapper.readValue(content.toString(), WeatherData.class);
            return daily;
        } catch (IOException e) {
            System.out.println("Error while connecting to the API");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Region[] getRegions() {
        try {
            URL uri = new URL(url + String.format(regions_endpoint, api_key, language));
            System.out.println(uri);
            HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            ObjectMapper mapper = new ObjectMapper();
           Region[] regions = mapper.readValue(content.toString(), Region[].class);
            return regions;
        } catch (IOException e) {
            System.out.println("Error while connecting to the API");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Country[] getCountries (String region_key) {
        try {
            URL uri = new URL(url + String.format(countries_endpoint,region_key, api_key, language));
            System.out.println(uri);
            HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            Country[] countries = mapper.readValue(content.toString(), Country[].class);
            return countries;
        } catch (IOException e) {
            System.out.println("Error while connecting to the API");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public AdministrativeArea[] getAdminArea(String country_key){
        try {
            URL uri = new URL(url + String.format(admin_ares_endpoint,country_key, api_key, language));
            System.out.println(uri);
            HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            AdministrativeArea[] adminAreas = mapper.readValue(content.toString(), AdministrativeArea[].class);
            return adminAreas;
        } catch (IOException e) {
            System.out.println("Error while connecting to the API");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public static class AppData {
        private String api_key;
        private String default_language;

        public String getApi_key() {
            return api_key;
        }

        public String getDefault_language() {
            return default_language;
        }

    }

}


