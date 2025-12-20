public class L190_ReverseBits {

	public static void main(String[] args) {
		L190_ReverseBits obj = new L190_ReverseBits();
		int num = 43261596;
		System.out.println("binary: "+Integer.toBinaryString(num));
		System.out.println("reverse: "+Integer.toBinaryString(obj.reverseBits(num)));
	}

    // Problem: https://leetcode.com/problems/reverse-bits/
    // Idea: Take lsb of n and |(or) it with res and shift res to right. Repeat this for 32 times.
	public int reverseBits(int n) {
        int res = 0;
        for(int i=0; i<32; i++){
            res = res << 1;
            res = res | ((n>>i)&1);
        }
        return res;
    }
}
