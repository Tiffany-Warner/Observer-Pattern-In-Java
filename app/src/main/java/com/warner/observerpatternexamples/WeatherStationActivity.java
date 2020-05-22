package com.warner.observerpatternexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//import com.warner.observerpatternexamples.weatherdataexample.WeatherData;
//import com.warner.observerpatternexamples.weatherdataexample.displays.CurrentConditionsDisplay;
//import com.warner.observerpatternexamples.weatherdataexample.displays.ForecastDisplay;
//import com.warner.observerpatternexamples.weatherdataexample.displays.StatisticsDisplay;
import com.warner.observerpatternexamples.weatherdatajavaobservable.WeatherData;
import com.warner.observerpatternexamples.weatherdatajavaobservable.displays.CurrentConditionsDisplay;
import com.warner.observerpatternexamples.weatherdatajavaobservable.displays.ForecastDisplay;
import com.warner.observerpatternexamples.weatherdatajavaobservable.displays.StatisticsDisplay;


public class WeatherStationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main();
    }

    public static void main(){
        //Create the subject
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        //Simulates new weather measurements
        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(50,90,29.2f);
    }
}
