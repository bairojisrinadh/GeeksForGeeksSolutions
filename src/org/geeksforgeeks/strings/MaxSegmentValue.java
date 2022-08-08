package org.geeksforgeeks.strings;

public class MaxSegmentValue {

	public static void main(String[] args) {
		String s = "999";
		int k = 1;
		int max = extract(s, k);
		System.out.println(max);
	}

	private static int extract(String s, int k) {
		if (k > s.length()) {
			return -1;
		} else if (k == s.length()) {
			return Integer.parseInt(s);
		}
		
		int max = 0;
		int nBreaks = s.length() - k;
		
		for(int i = 0; i < s.length() - nBreaks; i++) {
			int val = Integer.parseInt(s.substring(i, i + nBreaks));
			if(val > max)
				max = val;
		}
		
		int last = Integer.parseInt(s.substring(nBreaks));
		if(last > max)
			max = last;
		
		return max;
	}
}
