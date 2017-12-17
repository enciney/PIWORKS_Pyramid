package com.encine;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Pyramid {
	
	ArrayList<Integer> p_list ; 
	int height ;
	
	public Pyramid() {
		p_list = new ArrayList<Integer>();
		height = 0;
		
	}
	
	public  void readFile(String file)  {
		int value = 0 ;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String str;
			
			
			while(( str = in.readLine()) != null) {
				if(value == 0 ) {
					int s = Integer.parseInt(str) ;
					p_list.add(s);
					
				}
					
				else
					addtoList(str);
				
				value++ ;
			}
			height = value ;
			in.close();	
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	
		
	}
	
	private   void addtoList(String str)
	{
		StringTokenizer token = new StringTokenizer(str,"\n ");
		while(token.hasMoreElements())
		{
			String value = token.nextToken();
			
			p_list.add(Integer.parseInt(value));
		}	
	
	}
	

	private boolean isPrime(int value) {
		
		for(int i = 2 ; i<= value/2 ; i++)
			if(value % i == 0)
				return false ;
		
		return true ; 
	}
	
	public int foundMaxSum() {
		if(this.height == 1)
			return this.p_list.get(0);
		
		return foundMaxSum(0,1); 
		
	}
	
private int foundMaxSum(int rootIndex,int currentHeight) {
	if(currentHeight + 1 == this.height)
	{
		int root = p_list.get(rootIndex);
		int left = p_list.get(getLeftIndex(rootIndex,currentHeight));
		int right = p_list.get(getRightIndex(rootIndex,currentHeight));
		if(isPrime(left) && isPrime(right))
			return root ;
		else
		{
			if(isPrime(left))
				return root + right ; 
			else if(isPrime(right))
				return root + left ;
			
			else {
			return (root +left > root + right ?  root+left : root+right);	
			
			}
			
		}		
	}	
	
	else
	{
		
		int leftIndex = getLeftIndex(rootIndex,currentHeight);
		int rightIndex = getRightIndex(rootIndex,currentHeight);
		int leftValue = 0 ; 
		int rightValue =  0 ; 
		boolean isLeftPrime = isPrime(p_list.get(leftIndex));
		boolean isRightPrime = isPrime(p_list.get(rightIndex));
		if(!isLeftPrime && !isRightPrime)
		{
			leftValue = p_list.get(rootIndex) +   foundMaxSum(leftIndex,currentHeight+1);
			rightValue = p_list.get(rootIndex) +   foundMaxSum(rightIndex,currentHeight+1);
			return (leftValue> rightValue ?  leftValue : rightValue);
		}
			
		else
		{	
			if(!isLeftPrime)
				leftValue = p_list.get(rootIndex) +   foundMaxSum(leftIndex,currentHeight+1);
			else if(!isRightPrime) 
				rightValue = p_list.get(rootIndex) +   foundMaxSum(rightIndex,currentHeight+1);
		
			return (leftValue> rightValue ?  leftValue : rightValue);	
		}
	
		
	}	
		
}



	private int getLeftIndex(int index,int current_height)
	{
		return index+current_height;
		
	}

	private int getRightIndex(int index,int current_height)
	{
	
		return getLeftIndex(index+1,current_height);
		
	}
	
	
	

}
