package org.geeksforgeeks.strings;

public class DivBy999 {

	public static void main(String[] args) {
		String s = "1998";
		boolean isDivBy999 = isDivBy999(s);
		System.out.println(isDivBy999);
	}

	private static boolean isDivBy999(String s) {
		int lenMulOf3 = s.length() % 3; //1
		
		if(lenMulOf3 != 0) {
			while(lenMulOf3 != 3) {//3
				s = "0" + s;
				lenMulOf3++;
			}
		}
		
		int sum = 0;
		for(int i = 0; i < s.length(); i += 3) {//O(N/3)
			int digit3 = Integer.valueOf(s.substring(i, i + 3));
			sum += digit3;
		}
			
		return sum == 999;
	}
}
