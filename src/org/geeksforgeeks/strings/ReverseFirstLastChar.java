package org.geeksforgeeks.strings;

public class ReverseFirstLastChar {

	public static void main(String[] args) {
		String str = "geeks for geeks";
		char[] ch = str.toCharArray();
		for(int i = 0; i < ch.length; i++) {
			int k = i;
			while(i < ch.length && ch[i] != ' ')
				i++;
			//swap
			char temp = ch[k];
			ch[k] = ch[i - 1];
			ch[i - 1] = temp;
		}
		System.out.println(new String(ch));
	}

}
