package algorithms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContiguousSubsetProduct {

	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		for(int t=0; t<tests; t++){
		    String input[] = br.readLine().split(" ");
		    long n = Long.parseLong(input[0]);
		    long k = Long.parseLong(input[1]);
		    String inputArr[] = br.readLine().split(" ");
		    long product = 1;
		    int i=0;
		    int count = 0;
		    for(int j=0; j<inputArr.length; j++){
		        product *= Integer.parseInt(inputArr[j]);
	            if(product < k){
	                count += (j-i+1);
	            }else{
	                while(product > k){
	                    product /= Integer.parseInt(inputArr[i++]);
	                }
	                if(product < k){
	                    count += (j-i+1);
	                }
	            }
		    }
		    System.out.println(count);
		}
	}

}
