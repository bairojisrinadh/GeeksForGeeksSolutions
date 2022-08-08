package org.geeksforgeeks.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidIntOrFloat {
	
	public static void main(String[] args) {
		String intStr = "1234";
		String invalidIntStr = "abc";
		checkInt(intStr);
		checkInt(invalidIntStr);
		String floatStr = "10e5";
		String invalidFloatStr = "11e3.5";
		checkFloat(floatStr);
		checkFloat(invalidFloatStr);
	}

	/**
	 * Regex for float:
	 * sign = - | +
	 * digit = 0 | 1 | ... | 9
	 * optional_decimal = .digit digit*
	 * optional_exponent = ((E|e)(+|-|epsilon)digit digit*) | epsilon
	 *
	 * pattern for float = sign digit digit* optional_decimal optional_exponent
	 */
	private static void checkFloat(String str) {
		final String intRegex = "[+-]?[0-9][0-9]*(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";
		Pattern p = Pattern.compile(intRegex);
		Matcher m = p.matcher(str);
		if(m.find() && m.group().equals(str))
			System.out.println(str + " is valid float.");
		else
			System.out.println(str + " is not a valid float.");
	}

	/**
	 *	Regex of Integer: 
	 *	sign = + | -
	 *	digit = 0 | 1 | ... | 9
	 *	num = sign digit digit* 
	 * 
	 */
	private static void checkInt(String str) {
		final String intRegex = "[+-]?[0-9][0-9]*";
		Pattern p = Pattern.compile(intRegex);
		Matcher m = p.matcher(str);
		if(m.find() && m.group().equals(str))
			System.out.println(str + " is valid integer.");
		else
			System.out.println(str + " is not a valid integer.");
	}
}
