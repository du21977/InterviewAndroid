package com.java.hash;

/**
 * 重写equals和hashCode
 * 比较对象，先比较hashCode，再比较equals
 */
public class Test {
	
	int hashCode = 99999;
	
	String name;

	public static void main(String[] args) {
		Integer a = 5;
		Integer b = 5;
		//进行自动拆箱了,比较的是值
		System.out.println(a == b);  //true

		Integer c = new Integer(5);
		Integer d = new Integer(5);
		//引用类型比较的地址
		System.out.println(c == d);  //false
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Test test = (Test) o;

		if (hashCode != test.hashCode) return false;
		return name.equals(test.name);

	}
}
