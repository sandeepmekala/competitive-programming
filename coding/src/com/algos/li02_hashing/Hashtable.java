package  com.algos.li02_hashing;

public class Hashtable {

	public static void main(String[] args) {
		// TODO:	
		// -> collision handling techniques: chaining, open addressing
		// -> Chaining: 
		//		-> can use linked list, arraylist or balance bst for storing elements
		// -> open addressing: keep looking the hashtable until an empty slot is found
		//		-> for delete, mark deleted nodes as 'x' so that search won't fail
		//		-> next slot can be found using these methods:
		//			-> 1. linear probing: search next slot linearly (hash(x)+1)%size
		//				-> good cache performance and but clustering problem
		//				-> problems: 
		//					-> primary clustering - consecutive numbers from groups
		//					-> secondary clustering - 2 records can have same prod sequence if their initial position is same
		//			-> 2. quadratic probing: look for i^2 position like (hash(x)+1*1)%size, (hash(x)+2*2)%size
		//			-> 3. double hashing: we use another hash function hash2(x). Look for (hash(x)+1*hash2(x))%size, (hash(x)+2*hash2(x))%size
		//				-> bad cache performance and no clustering 
	}

}
