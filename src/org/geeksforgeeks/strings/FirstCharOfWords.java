package org.geeksforgeeks.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstCharOfWords {
	public static void main(String[] args) {
		String s1 = "Geeks for Geeks";
		String s2 = "This is the Bot";
		printFirst(s1);
		printFirst(s2);
	}

	private static void printFirst(String s) {
		Pattern p = Pattern.compile("\\b[a-zA-Z]");
		Matcher m = p.matcher(s);
		
		while(m.find())
			System.out.print(m.group());
		
		System.out.println();
	}
}
