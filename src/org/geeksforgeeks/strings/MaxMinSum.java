package org.geeksforgeeks.strings;

public class MaxMinSum {

	public static void main(String[] args) {
		int x1 = 5466, x2 = 4555;
		calculateMaxMinSum(x1, x2);
	}

	private static void calculateMaxMinSum(int x1, int x2) {
		int minSum = replace(x1, 6, 5) + replace(x2, 6, 5);
		System.out.println("MinSum: " + minSum);
		int maxSum = replace(x1, 5, 6) + replace(x2, 5, 6);
		System.out.println("MaxSum: " + maxSum);
	}

	private static int replace(int num, int i, int j) {
		int replace = 0;
		int pow = 0;
		
		while(num != 0) {
			int digit = num % 10;
			if(digit == i)
				digit = j;
			replace += digit * (int) Math.pow(10, pow++);
			num /= 10;
		}
		
		return replace;
	}
}
