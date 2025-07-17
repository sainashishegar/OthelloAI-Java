package ca.yorku.eecs3311.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implement a modification of the Observer/Observable
 * Design Pattern. See https://www.oodesign.com/observer-pattern.html
 *
 * @author student
 */
public class Observable {
    private ArrayList<Observer> observers = new ArrayList<Observer>();


    /**
     * adds new observer
     * @param o: observer object
     */
    public void attach(Observer o) {
        observers.add(o);
    }

    /**
     * removes an observer
     * @param o: observer object
     */
    public void detach(Observer o) {
        observers.remove(o);
    }

    /**
     * notifies all attached observers of an update
     */
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

}
