package com.warner.observerpatternexamples.weatherdatajavaobservable.displays;

import com.warner.observerpatternexamples.weatherdatajavaobservable.WeatherData;
import com.warner.observerpatternexamples.weatherdatajavaobservable.interfaces.DisplayElement;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;
    private float pressure;
    private ArrayList<Float> temperatures;
    private float averageTemp;
    private float maxTemp;
    private float minTemp;

    public StatisticsDisplay(Observable obs) {
        this.observable = obs;
        observable.addObserver(this);
        temperatures = new ArrayList();
    }


    //When update() is called, save the temp and humidity and call display()
    public void update(Observable observable, Object arg){
        if(observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) observable;
            this.temperature = weatherData.getTemperature();
            this.temperatures.add(temperature);
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            this.averageTemp = calculateAvgTemp();
            this.maxTemp = getMaxTemp();
            this.minTemp = getMinTemp();
            display();
        }
    }

    public void display(){
        System.out.println("Avg/Max/Min temperature =" + averageTemp + "/" + maxTemp + "/" + minTemp);
    }

    private float calculateAvgTemp() {
        float sum = 0;
        for (Float temp : temperatures){
            sum += temp;
        }
        if(temperatures.size() > 0) {
            float average = sum / temperatures.size();
            return average;
        }
        return 0;
    }

    private float getMaxTemp(){
        float max = 0;
        for(Float temp: temperatures){
            if(temp > max){
                max = temp;
            }
        }
        return max;
    }
    private float getMinTemp(){
        float min = 1000; //start temp
        for(Float temp: temperatures){
            if(temp < min){
                min = temp;
            }
        }
        return min;
    }
}
