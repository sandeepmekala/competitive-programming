import java.util.ArrayList;
import java.util.Collections;

public class Test implements Interface {

	public static void main(String[] args) {
		System.out.println(Interface.str);
		System.out.println("60".compareTo("509"));
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("54"); 
        arr.add("546"); 
        arr.add("548"); 
        arr.add("60"); 
		Collections.sort(arr);
		Collections.reverse(arr);
		System.out.println(arr);
		System.out.println(String.join("", arr));
	}

	@Override
	public void getStr() {
		// TODO Auto-generated method stub

	}

}

interface Interface {
	String str = "sandeed";

	public void getStr();
}

//abstract class AbstractEg {
//
//	public static void main(String aa[]) {
//		System.out.println("Inside main method");
//		disp();
//	}
//
//	abstract void disp1();
//
//	public static void disp() {
//
//		System.out.println("Abstract method called");
//
//	}
//
//}