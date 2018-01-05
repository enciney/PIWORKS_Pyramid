package com.encine;

public class Main {
	static final String   fileName = "src\\pyramid.txt" ; 

	public static void main(String[] args) {
		Pyramid pyramid = new Pyramid();
		pyramid.readFile(fileName);
		System.out.println("\nresult : " + pyramid.foundMaxSum());
		
	
	}
	

}
