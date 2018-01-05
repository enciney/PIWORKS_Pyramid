package com.encine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Pyramid {

	ArrayList<Integer> p_list;
	int height;
	public static final boolean DEBUG = false ; 

	public Pyramid() {
		p_list = new ArrayList<Integer>();
		height = 0;

	}

	public void readFile(String file) {
		int value = 0;

		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String str;

			while ((str = in.readLine()) != null) {
				if (value == 0) {
					int s = Integer.parseInt(str);
					p_list.add(s);

				}

				else
					addtoList(str);

				value++;
			}
			height = value;
			in.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private void addtoList(String str) {
		StringTokenizer token = new StringTokenizer(str, "\n ");
		while (token.hasMoreElements()) {
			String value = token.nextToken();

			p_list.add(Integer.parseInt(value));
		}

	}

	private boolean isPrime(int value) {

		for (int i = 2; i <= value / 2; i++)
			if (value % i == 0)
				return false;

		return true;
	}

	public int foundMaxSum() {
		if (this.height == 1)
			return this.p_list.get(0);

		int result = foundMaxSum(0, 1);
		if(DEBUG)
			primeCheck();
		return result ;
	}

	private int foundMaxSum(int rootIndex, int currentHeight) {
		if (currentHeight + 1 == this.height) {
			int root = p_list.get(rootIndex);
			int left = p_list.get(getLeftIndex(rootIndex, currentHeight));
			int right = p_list.get(getRightIndex(rootIndex, currentHeight));
			
			// This algorithm must reach the leaf node so if a node's leafs are prime then return 0
			// Because max path should not be track this way , mentioned above that absolutely must reach the leaf node 
			if (isPrime(left) && isPrime(right)) {
				if(DEBUG)
					System.out.println(root );
				return 0;
			}
				
			else {
				if (isPrime(left)) {
					if(DEBUG)
						System.out.println(root + right);
					return root + right;
				}
				else if (isPrime(right)) {
					if(DEBUG)
						System.out.println(root + left);
					return root + left;
					
				}

				else {
					if(DEBUG)
						System.out.println(root + left > root + right ? root + left : root + right);
					return (root + left > root + right ? root + left : root + right);

				}

			}
		}

		else {
          
			int leftIndex = getLeftIndex(rootIndex, currentHeight);
			int rightIndex = getRightIndex(rootIndex, currentHeight);
			int leftValue = 0;
			int rightValue = 0;
			boolean isLeftPrime = isPrime(p_list.get(leftIndex));
			boolean isRightPrime = isPrime(p_list.get(rightIndex));
			if (!isLeftPrime && !isRightPrime) {
				leftValue = p_list.get(rootIndex) + foundMaxSum(leftIndex, currentHeight + 1);
				rightValue = p_list.get(rootIndex) + foundMaxSum(rightIndex, currentHeight + 1);
				if(DEBUG)
					System.out.println("left and right : " +  ( leftValue > rightValue ? leftValue : rightValue));
				return (leftValue > rightValue ? leftValue : rightValue);
			}

			else {
				if (!isLeftPrime)
					leftValue = p_list.get(rootIndex) + foundMaxSum(leftIndex, currentHeight + 1);
				else if (!isRightPrime)
					rightValue = p_list.get(rootIndex) + foundMaxSum(rightIndex, currentHeight + 1);
				if(DEBUG)	
					System.out.println("anyone prime : " + (leftValue > rightValue ? leftValue : rightValue));
				return (leftValue > rightValue ? leftValue : rightValue);
				
			}

		}

	}

	private int getLeftIndex(int index, int current_height) {
		return index + current_height;

	}

	private int getRightIndex(int index, int current_height) {

		return getLeftIndex(index + 1, current_height);

	}
	
	/*################################################################################
	 * BELOW CODE IMPLEMENTED FOR FOUND WHICH NODE IS NOT AVAILABLE FOR CALCULATION
	 *################################################################################*/

	// Mark Array Elements as a Prime Number ;  if element is prime number or elements nodes are prime number 
		public void primeCheck()
		{
			System.out.print("\n" );
			ArrayList<Integer> copylist = p_list ;
			int size = copylist.size();
			int current_height = 1 ;
			for(int i = 0 ; i < size ; i++)
			{
				int value = copylist.get(i) ;
				if(isPrime(value))
					System.out.print("-10\t" );
				else {
					
					if(isNodePrime(i,current_height,copylist) && i != 0) {
						System.out.print("-10\t" );
						copylist.set(i, 2);
					}
					else	
						System.out.print(value +"\t" );
				}
				
				if( i == ( current_height * (current_height+1) ) / 2 - 1 ) {
					System.out.println("");
					current_height++ ;
					
				}			
				
			}	
			
		}
		
		private boolean isNodePrime(int index,int current_height,ArrayList<Integer> p_list)
		{
			int levelMaxIndex = (current_height * (current_height+1))/ 2 -1 ;
			int levelMinIndex = (current_height * (current_height-1))/ 2 ; 
			// if first element of the level no left node exist
			if(index == levelMinIndex )
				return isPrime (p_list.get(  index - current_height+1)) ; 
			else if(index == levelMaxIndex )
				return isPrime (p_list.get(  index - current_height)) ; 
			else
				return isPrime(p_list.get(index - current_height)) && isPrime(p_list.get(index - current_height+1));
			
		}

}


