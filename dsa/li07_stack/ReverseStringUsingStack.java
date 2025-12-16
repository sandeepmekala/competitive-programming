
import java.util.Stack;

public class ReverseStringUsingStack {

	public static void main(String[] args) {
		ReverseStringUsingStack obj = new ReverseStringUsingStack();

		String str = "google";
		System.out.println(obj.reverseStringUsingStack(str));

	}

	public String reverseStringUsingStack(String s){
		Stack<Character> stack = new Stack<Character>();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<s.length(); i++){
			stack.push(s.charAt(i));
		}

		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}

		return sb.toString();
	}

}
