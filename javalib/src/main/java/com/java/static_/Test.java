package com.java.static_;


/**
 * 子类不能重写父类静态方法，静态方法属于类，在编译期间就绑定了，多态在运行期间绑定
 */
public class Test {

	public static void main(String[] args) {
		Child c = new Child();
		Child.func();
		c.my();
	}

}
