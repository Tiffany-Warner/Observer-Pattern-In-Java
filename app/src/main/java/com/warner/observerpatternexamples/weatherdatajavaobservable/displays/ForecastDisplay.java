package com.warner.observerpatternexamples.weatherdatajavaobservable.displays;

import com.warner.observerpatternexamples.weatherdatajavaobservable.WeatherData;
import com.warner.observerpatternexamples.weatherdatajavaobservable.interfaces.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;
    private float pressure;

    public ForecastDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    public void update(Observable observable, Object arg){
        if(observable instanceof WeatherData){
            WeatherData weatherData = (WeatherData) observable;
            this.pressure = weatherData.getPressure();
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
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
