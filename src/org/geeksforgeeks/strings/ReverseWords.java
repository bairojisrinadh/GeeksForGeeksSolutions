package org.geeksforgeeks.strings;

import java.util.regex.Pattern;

public class ReverseWords {
	public static void main(String[] args) {
		String s = "come in now";
		reverseOwn(s);
		gfgSolution(s);
	}

	private static void gfgSolution(String s) {
		Pattern p = Pattern.compile("\\s");
		String[] tmp = p.split(s);
		String res = "";
		for(int i = 0; i < tmp.length; i++) {
			if(i == tmp.length - 1)
				res = tmp[i] + res;
			else
				res = " " + tmp[i] + res;
		}
		System.out.println(res);
	}

	private static void reverseOwn(String s) {
		char[] ch = s.toCharArray();
		int k = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != ' ')
				continue;
			swap(ch, k, i - 1);
			k = i + 1;
		}
		// swap last word
		swap(ch, k, ch.length - 1);
		swap(ch, 0, ch.length - 1);
		System.out.println(new String(ch));
	}

	private static void swap(char[] ch, int low, int high) {
		while (low < high) {
			char tmp = ch[low];
			ch[low] = ch[high];
			ch[high] = tmp;
			low++;
			high--;
		}
	}
}
