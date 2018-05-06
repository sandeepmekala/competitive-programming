package stacks;

public class StackUsingArrayMain {

	public static void main(String[] args) {
		StackUsingArray stack = new StackUsingArray();
		
		stack.push(10);
		stack.print();
		stack.push(20);
		stack.print();
		stack.push(30);
		stack.print();
		stack.pop();
		stack.print();
		System.out.println("\n"+stack.top());
		stack.print();

	}

}
