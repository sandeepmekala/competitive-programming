package edu.java.java8;

interface Sayable5 {
	public String say();
}

public class LambdaExpressionExample3 {
	public static void main(String[] args) {
		Sayable5 s = () -> {
			return "I have nothing to say.";
		};
		System.out.println(s.say());
	}
}