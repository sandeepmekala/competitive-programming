
package com.java.java8new.li01.defaultMethod;

@FunctionalInterface
interface Interface1 {

	void method1(String str);

	default void log(String str) {
		System.out.println("I1 logging::" + str);
	}
}

interface Interface2 {

	void method2(String str);

	default void log(String str) {
		System.out.println("I2 logging::" + str);
	}

}

public class DefaultMethod implements Interface1, Interface2 {

	@Override
	public void method1(String str) {
	}

	@Override
	public void method2(String str) {
	}

	// MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str) {
		System.out.println("MyClass logging::" + str);
	}

	public static void main(String[] args) {
		DefaultMethod obj = new DefaultMethod();
		obj.log("Java");

		// anonymous object/class
		Interface1 int1 = new Interface1(){

			@Override
			public void method1(String str) {
				
			}
		};
	}
}