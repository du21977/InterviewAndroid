package com.java.oop;

//飞机业务类
public class PlaneBiz {

	//这里存在多态   父类引用指向子类对象
	public void doSomething(Plane c){
		c.fly();
	}
	

}
