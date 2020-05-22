package com.warner.observerpatternexamples.weatherdatajavaobservable;

import java.util.Observable;

/**
 * Observables can be setup using the push or pull method.
 * This is using the pull model because we call notifyObservers without passing
 * an  object. The getter methods allow Observers to "pull" the WeatherData object's state.
 * We also don't need to track our Observers anymore since the superclass will handle
 * that for us.
 */
public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){ }

    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    //other WeatherData methods

}