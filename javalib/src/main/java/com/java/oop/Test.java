package com.java.oop;


/**
 * 接口的好处
 * 提高程序维护和可扩展性
 * 弥补java不能多继承的缺点
 */
public class Test {

	public static void main(String[] args) {
		PlaneBiz biz = new PlaneBiz();
		biz.doSomething(new Jet());
		
		biz.doSomething(new UFO());
	}

}
