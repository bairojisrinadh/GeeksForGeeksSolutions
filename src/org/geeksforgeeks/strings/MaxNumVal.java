package org.geeksforgeeks.strings;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxNumVal {
	public static void main(String[] args) {
		String s = "100klh564231315151313151315abc365bg";
//		int max = extract(s);
		BigInteger max = extractGFG(s);
		System.out.println(max);
	}

	private static BigInteger extractGFG(String s) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(s);
		BigInteger max = BigInteger.ZERO;
		
		while(m.find()) {
			BigInteger obj = new BigInteger(m.group());
			
			if(obj.compareTo(max) > 0)
				max = obj;
		}
		
		return max;
	}

	private static int extract(String s) {
		String tmp = "";
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				tmp += ch;
			} else {
				if (tmp != "") {
					int val = Integer.parseInt(tmp);
					if(val > max)
						max = val;
				}
				tmp = "";
			}
		}
		if(tmp != "") {
			int val = Integer.parseInt(tmp);
			if(val > max)
				max = val;
		}
		return max;
	}
}
