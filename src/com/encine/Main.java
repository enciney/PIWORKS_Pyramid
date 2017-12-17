package com.encine;

public class Main {
	static final String   fileName = "src\\pyramid.txt" ; 
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Pyramid pyramid = new Pyramid();
		pyramid.readFile(fileName);
		
		
		System.out.println( pyramid.foundMaxSum());

	}
	
	public static void readFile() {
		
		
		
	}

}
