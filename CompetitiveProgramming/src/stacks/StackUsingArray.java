package stacks;

public class StackUsingArray {
	
	private int max_size = 101;
	private int elements[] = new int[max_size];
	private int top = -1;
	
	public void push(int data){
		if(top == max_size-1){
			System.out.println("Error: Stack Overflow");
			return;
		}
		elements[++top] = data;
	}
	public void pop(){
		if(top == -1){
			System.out.println("Error: Stack has no elements");
			return;
		}
		top--;
	}
	public int top(){
		if(top == -1){
			System.out.println("Error: Stack has no elements");
			return -1;
		}
		return elements[top];
	}
	public void isEmpty(){
		if(top == -1){
			System.out.println("Stack is empty");
		}
	}
	public void print(){
		System.out.println();
		for(int i=0; i<=top; i++){
			System.out.print(elements[i]+" ");
		}
	}

}
