package org.geeksforgeeks.strings;

public class DecimalDivBy5 {
	public static void main(String[] args) {
		String binary = "100110011001100110011001";
		boolean isDivBy5 = check(binary);
		System.out.println(isDivBy5);
	}

	private static boolean check(String s) {
		if(s.length() < 3) {
			return false;
		}
		int dec = getDecimal(s);
		return dec % 5 == 0;
	}

	private static int getDecimal(String s) {
		int dec = 0;
		int pow = 1;
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == '1') {
				dec += pow;
			}
			pow *= 2;
		}
		System.out.println("Decimal: " + dec);
		return dec;
	}
}
