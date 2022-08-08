package org.geeksforgeeks.strings;

public class DiffLargeNos {
	
	public static void main(String[] args) {
		String s1 = "31435454654554";
		String s2 = "122387876566565674";
		String diff = diff(s1, s2);
		System.out.println(diff);
	}
	
	private static String diff(String s1, String s2) {
		
		if(isSmaller(s1, s2)) {
			String tmp = s1;
			s1 = s2;
			s2 = tmp;
		}

		int l1 = s1.length();
		int l2 = s2.length();
		int diff = l1 - l2;
		int carry = 0;
		String res = "";
		
		for(int i = l2 - 1; i >= 0; i--) {
			
			int sub = s1.charAt(i + diff) - s2.charAt(i) - carry;
			
			if(sub < 0) {
				sub += 10;
				carry = 1;
			} else {
				carry = 0;
			}
			
			res += sub;
		}
		
		for(int i = l1 - l2 - 1; i >= 0; i--) {
			if(s1.charAt(i) == '0' && carry > 0) {
				res += '9';
				continue;
			}
			
			int sub = (((int)s1.charAt(i) - (int)'0') - carry); 
	        if (i > 0 || sub > 0) // remove preceding 0's 
	            res += String.valueOf(sub); 
	        carry = 0; 
		}
		
		return new StringBuilder(res).reverse().toString();
	}

	private static boolean isSmaller(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		
		if(l1 < l2) {
			return true;
		} else if(l1 > l2) {
			return false;
		}
		
		for(int i = 0; i < l1; i++) {
			if(s1.charAt(i) < s2.charAt(i))
				return true;
			else if(s1.charAt(i) > s2.charAt(i))
				return false;
		}
		return false;
	}
}
