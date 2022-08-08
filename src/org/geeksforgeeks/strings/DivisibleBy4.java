package org.geeksforgeeks.strings;

public class DivisibleBy4 {

	public static void main(String[] args) {
		String s1 = "363588395960667043875487";
		boolean divBy4 = divBy4(s1);
		System.out.println(divBy4);
	}

	private static boolean divBy4(String s1) {
		if(s1.length() == 1) {
			int single = s1.charAt(0) - '0';
			if(single == 4 || single == 8)
				return true;
			else
				return false;
		}
		
		int last2 = Integer.parseInt(s1.substring(s1.length() - 2));
		
		if(last2 % 4 == 0)
			return true;
		
		return false;
	}
}
