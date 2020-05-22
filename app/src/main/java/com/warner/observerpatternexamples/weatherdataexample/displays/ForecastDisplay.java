package com.warner.observerpatternexamples.weatherdataexample.displays;

import com.warner.observerpatternexamples.weatherdataexample.WeatherData;
import com.warner.observerpatternexamples.weatherdataexample.interfaces.DisplayElement;
import com.warner.observerpatternexamples.weatherdataexample.interfaces.Observer;

public class ForecastDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    //When update() is called, save the temp and humidity and call display()
    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display(){
        if(temperature >= 80) {
            System.out.println("Forecast: " + "Warm weather on the way!");
        }
        else if(temperature < 80 && temperature > 60){
            System.out.println("Forecast: " + " Warm weather on the way!");
        } else{
            System.out.println("Forecast: " + "Brrrr! It's gonna be chilly");
        }
    }
}
