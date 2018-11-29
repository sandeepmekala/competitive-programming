package stacks;

public class StackUsingLinkedListMain {

	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		
		stack.push(10);
		System.out.println();
		stack.print();
		stack.push(20);
		System.out.println();
		stack.print();
		stack.push(30);
		System.out.println();
		stack.print();
		stack.pop();
		System.out.println();
		stack.print();
		System.out.println("\nPrinting top element:");
		System.out.println(stack.top());
		stack.print();
		System.out.println("\nChecking if stack is empty:");
		System.out.println(stack.isEmpty());
	}

}
