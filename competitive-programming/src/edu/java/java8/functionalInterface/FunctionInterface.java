package edu.java.java8.functionalInterface;

@FunctionalInterface
interface sayable {
	// single abstract method
	void say(String msg);

	// It can contain any number of Object class methods.
	int hashCode();

	String toString();

	boolean equals(Object obj);

	// It can contain default method
	default void doIt() {
		System.out.println("Do it now");
	}

	// trying to override Object method gives compile time error as
	// "A default method cannot override a method from java.lang.Object"

	// default String toString(){
	// return "i1";
	// }
}

public class FunctionInterface implements sayable {
	public void say(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		FunctionInterface fie = new FunctionInterface();
		fie.say("Hello there");
		fie.doIt();
	}
}