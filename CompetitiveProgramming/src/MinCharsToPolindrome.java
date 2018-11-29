//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//public class MinCharsToPolindrome {
//
//	public static void main(String[] args) {
//		//Ab3bd
//		
//		//Ab3bdA
//		//Adb3bdA
//		Scanner sc = new Scanner(System.in);
//    	int N = sc.nextInt();
//    	sc.nextLine();
//    	String str = sc.nextLine();
//    	int count = 0;
//    	if(str.isEmpty()){
//    		count = 0;
//    	}else if(str.length() == 1){
//    		count = 1;
//    	}
//    	
//    	ArrayList<String> chars = new ArrayList<String>(Arrays.asList(str.split("")));
//    	int i=0;
//    	int j=chars.size()-1;
//    	while(i<j){
//    		if(chars.get(i).equals(chars.get(j))){
//    			i++;
//    			j--;
//    		}else{
//    			chars.add("");
//    			chars.add("");
//    			chars.set
//    			chars.set(j+1, chars.get(i));
//    			chars.set(i+1, chars.get(j));
//    			j++;
//    			count += 2;
//    		}
//    	}
//    	System.out.println(count);
//    	System.out.println(chars.toString());
//	}
//}
