
public class Test implements Interface {

	public static void main(String[] args) {
		System.out.println(Interface.str);
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

abstract class AbstractEg {

	public static void main(String aa[]) {
		System.out.println("Inside main method");
		disp();
	}

	abstract void disp1();

	public static void disp() {

		System.out.println("Abstract method called");

	}

}