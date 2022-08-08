package org.geeksforgeeks.strings;

public class SumOfLargeNos {
	
	public static void main(String[] args) {
		String s1 = "7777555511111111";
		String s2 = "3332222221111";
		
		String getSum = getSum(s1, s2);
		System.out.println(getSum);
	}

	private static String getSum(String s1, String s2) {
		int s1N = s1.length();
		int s2N = s2.length();
		if(s1N == 0 && s2N == 0)
			return "0";
		else if(s1N == 0)
			return s2;
		else if(s2N == 0)
			return s1;
		
		String sum = "";
		int carry = 0;
		int i = s1N - 1, j = s2N - 1;
		for(; i >= 0 && j >= 0; i--, j--) {
			int x = Integer.parseInt(""+s1.charAt(i));
			int y = Integer.parseInt(""+s2.charAt(j));
			int s = x + y;
			if(carry != 0) {
				s = s + carry;
				carry = 0;
			}
			if(s > 9) {
				int remainder = s % 10;
				sum  = ("" + remainder) + sum;
				carry = s / 10;
			} else {
				sum  = ("" + s) + sum;
			}	
		}
		
		while(i >= 0) {
			int val = Integer.parseInt(""+s1.charAt(i));
			if(carry != 0) {
				val = val + carry;
				carry = 0;
			}
			sum = val + sum;
			i--;
		}
		
		while(j >= 0) {
			int val = Integer.parseInt(""+s2.charAt(j));
			if(carry != 0) {
				val = val + carry;
				carry = 0;
			}
			sum = val + sum;
			i--;
		}
		
		if(carry != 0) {
			sum = carry + sum;
		}
		
		return sum;
	}
}
