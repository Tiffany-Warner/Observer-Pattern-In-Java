package com.warner.observerpatternexamples.weatherdataexample.displays;

import com.warner.observerpatternexamples.weatherdataexample.interfaces.DisplayElement;
import com.warner.observerpatternexamples.weatherdataexample.interfaces.Observer;
import com.warner.observerpatternexamples.weatherdataexample.interfaces.Subject;

/**
 * Implements Observer so it can get changes from WeatherData which is the subject
 *
 * Implements DisplayElement because the API is going to require all display
 * elements to implement that interface
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData; //Used to store a reference to the subject

    //Constructor is passed the weatherData object(The Subject)
    // and we use it to register the display as an observer
    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    //When update() is called, save the temp and humidity and call display()
    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
