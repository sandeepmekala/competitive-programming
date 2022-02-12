package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FormBiggestNumberFromArray {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		//output should be 6054854654 
        /*list.add("54"); 
        list.add("546"); 
        list.add("548"); 
        list.add("60"); */
         
        // output should be 777776 
		/*list.add("7"); 
        list.add("776"); 
        list.add("7"); 
        list.add("7"); */
        
		/*list.add("59");
		list.add("598");*/
          
        //output should be 998764543431 
        list.add("1"); 
        list.add("34"); 
        list.add("3"); 
        list.add("98"); 
        list.add("9"); 
        list.add("76"); 
        list.add("45"); 
        list.add("4"); 
        

        System.out.println(formBiggestNumberFromArray(list));
	}
	private static String formBiggestNumberFromArray(ArrayList<String> list){
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				String str1 = s1+s2;
				String str2 = s2+s1;
				return str1.compareTo(str2)>0?-1:1;
			}
			
		});
		
		return String.join("", list);
	}
}
