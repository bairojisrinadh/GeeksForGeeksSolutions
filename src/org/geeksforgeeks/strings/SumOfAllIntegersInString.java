package org.geeksforgeeks.strings;

public class SumOfAllIntegersInString {

	public static void main(String[] args) {
		String s = "geeks4geeks";
//		int val = sum(s);
		int val = sumGFG(s);
		System.out.println(val);
	}

	private static int sumGFG(String s) {
		String tmp = "";
		int sum = 0;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(Character.isDigit(ch)) {
				tmp += ch;
			} else {
				if(tmp != "")
					sum += Integer.parseInt(tmp);
				tmp = "";
			}
		}
		if(tmp != "")
			sum += Integer.parseInt(tmp);
		
		return sum
				;
	}

	private static int sum(String s) {
		char[] ch = s.toCharArray();
		int i = 0;
		int k = i;
		int sum = 0;
		
		for (; i < ch.length; i++) {
			if(isDigit(ch[i])) {
				continue;
			} else {
				if(k != i) {
					sum += Integer.valueOf(s.substring(k, i));
				}
				k = i + 1;
			}
		}

		if(k < ch.length)
			sum += Integer.valueOf(s.substring(k, s.length()));
		
		return sum;
	}

	private static boolean isDigit(char ch) {
		int check = ch - '0';
		if (check >= 0 && check <= 9)
			return true;
		else
			return false;
	}
}
