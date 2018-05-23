package com.java.inner2;

/**
 * 内部类避免二异性
 */
public class InnerTest extends Parent {

	public static void main(String[] args) {

	}

	@Override
	public void func() {
		
	}
	
	class InnerClassA implements Inter {

		@Override
		public void func() {
			
		}
		
	}

}
