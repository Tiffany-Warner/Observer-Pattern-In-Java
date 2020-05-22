package com.warner.observerpatternexamples.weatherdatajavaobservable.displays;

import com.warner.observerpatternexamples.weatherdataexample.interfaces.DisplayElement;
import com.warner.observerpatternexamples.weatherdatajavaobservable.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * Implements Observer so it can get changes from WeatherData which is the subject
 *
 * Implements DisplayElement because the API is going to require all display
 * elements to implement that interface
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    //Constructor is passed the weatherData object(The Subject)
    // and we use it to register the display as an observer
    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this); //Add CurrentConditionsDisplay as an observer
    }

    // Takes an observable and an optional data argument
    public void update(Observable obs, Object arg){
        if(obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public void display(){
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
