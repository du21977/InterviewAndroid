package com.java.observer;

/**
 * Created by Administrator on 2018/5/11.
 */

public interface Observerable {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();

}
