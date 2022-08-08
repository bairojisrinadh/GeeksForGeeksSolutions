package org.geeksforgeeks.strings;

public class CompareStringLexi {
	
	public static void main(String[] args) {
		String s1 = "Geeks";
		String s2 = "Geeks1";
		
		int val = compare(s1, s2);
		System.out.println(val);
	}

	private static int compare(String s1, String s2) {
		for(int i = 0; i < s1.length() && i < s2.length(); i++) {
			if((int) s1.charAt(i) == (int) s2.charAt(i)) {
				continue;
			} else {
				return (int)s1.charAt(i) - (int) s2.charAt(i);
			}
		}
		if(s1.length() < s2.length())
			return s1.length() - s2.length();
		else if(s1.length() > s2.length())
			return s1.length() - s2.length();
		else
			return 0;
	}
}
