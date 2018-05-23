package com.java.observer;

/**
 * Created by Administrator on 2018/5/11.
 * 测试
 *
 * 观察者设计模式：触发联动
 */

public class Client {

    public  static void main(String[] args){

        //创建被观察者
        ConcreteObserverable concreteObserverable = new ConcreteObserverable();

        //创建三个不同的观察者
        Observer observerA = new ConcreteObserver("A");
        Observer observerB = new ConcreteObserver("B");
        Observer observerC = new ConcreteObserver("C");

        //将观察者注册到被观察者中
        concreteObserverable.registerObserver(observerA);
        concreteObserverable.registerObserver(observerB);
        concreteObserverable.registerObserver(observerC);

        //更新被观察者中的数据，当数据更新后，会自动通知所有已注册的观察者
        concreteObserverable.setInformatin(5,10);

    }

}
