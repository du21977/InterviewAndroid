package com.java.inner;

/**
 * 内部类可以实现多继承
 */
public class InnerTest {

	class InnerClassA extends ParentA{
		public int getAge(){
			return super.age;
		}
	}
	
	class InnerClassB extends ParentB {
		public String getName(){
			return super.name;
		}
	}
	
	
	public void doSomething(){
		new InnerClassA().getAge();
		new InnerClassB().getName();
	}
	
	
}
