package com.warner.observerpatternexamples.weatherdataexample.interfaces;

/**
 * The Observer is something that is subscribed to the Subject (aka Observable)
 * When changes occur in the Subject's state, all observers will be "updated"
 */
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
