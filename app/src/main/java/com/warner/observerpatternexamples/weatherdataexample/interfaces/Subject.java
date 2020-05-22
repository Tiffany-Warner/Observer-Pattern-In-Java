package com.warner.observerpatternexamples.weatherdataexample.interfaces;

import com.warner.observerpatternexamples.weatherdataexample.interfaces.Observer;

/**
 * The Subject to be observed -- The newspaper being subscribed to
 * Android refers to this as the Observable in their implementation
 */
public interface Subject {
    public void registerObserver(Observer o); //The Observer to be registered
    public void removeObserver(Observer o); //The Observer to be removed
    public void notifyObservers(); //Notify all observers when the Subject’s state has changed
}
