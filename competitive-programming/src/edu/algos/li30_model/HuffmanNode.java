package edu.algos.li30_model;

public class HuffmanNode implements Comparable<HuffmanNode> {

	public int freq;
	public char ch;

	public HuffmanNode left;
	public HuffmanNode right;

	@Override
	public int compareTo(HuffmanNode compartingWith) {
		return this.freq - compartingWith.freq;
	}
}