package com.java.observer;

/**
 * Created by Administrator on 2018/5/11.
 */

public class ConcreteObserver implements Observer {

    private String name;
    private int edition;
    private  float cost;

    public ConcreteObserver(String name){
        this.name = name;
    }

    @Override
    public void update(int edition, float cost) {
        this.edition = edition;
        this.cost =cost;
        buy();
    }

    private void buy() {

        System.out.println(name+"购买了第"+edition+"期的杂志，花费了"+cost+"元。");
    }


}
