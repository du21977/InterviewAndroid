package com.java.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class ConcreteObserverable implements Observerable {

    private List<Observer> mObservers ;
    private int edition;
    private int cost;

    public ConcreteObserverable(){
        mObservers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        mObservers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = mObservers.indexOf(o);
        if(i>=0){
            mObservers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {

        for (int i=0;i<mObservers.size();i++){
            Observer observer = mObservers.get(i);
            observer.update(edition,cost);
        }
    }

    public void setInformatin(int edition,int cost){
        this.edition = edition;
        this.cost =cost;
        notifyObservers();
    }
}
