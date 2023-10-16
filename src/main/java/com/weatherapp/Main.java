package com.weatherapp;

import com.weatherapp.models.City;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.concurrent.CompletableFuture;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("WeatherApp");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
        /*
        WeatherAppService service= new WeatherAppService();
        City cities[] = service.GetLocations("Warszawa");
        for (City city : cities)
            System.out.println(city.getLocalizedName()+" "+city.getAdministrativeArea().getLocalizedName());
    */
    }

}