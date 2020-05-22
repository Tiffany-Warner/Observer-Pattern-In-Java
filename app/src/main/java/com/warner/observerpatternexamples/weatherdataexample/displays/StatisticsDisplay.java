package com.warner.observerpatternexamples.weatherdataexample.displays;

import com.warner.observerpatternexamples.weatherdataexample.WeatherData;
import com.warner.observerpatternexamples.weatherdataexample.interfaces.DisplayElement;
import com.warner.observerpatternexamples.weatherdataexample.interfaces.Observer;

import java.util.ArrayList;

public class StatisticsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private ArrayList<Float> temperatures;
    private float averageTemp;
    private float maxTemp;
    private float minTemp;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
        temperatures = new ArrayList();
    }


    //When update() is called, save the temp and humidity and call display()
    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.temperatures.add(temperature);
        this.humidity = humidity;
        this.pressure = pressure;
        this.averageTemp = calculateAvgTemp();
        this.maxTemp = getMaxTemp();
        this.minTemp = getMinTemp();
        display();
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
