package org.geeksforgeeks.strings;

public class RangeExpand {

	public static void main(String[] args) {
		String str = "1-5, 8, 11-14, 18, 20, 26-29";
//		expand(str);
		expand2(str);
	}

	private static void expand2(String str) {
		StringBuilder sb = new StringBuilder();
		String[] words = str.split(", ");
		for(int i = 0; i < words.length; i++) {
			String[] range = words[i].split("\\-");
			if(range.length == 2) {
				int a = Integer.parseInt(range[0]);
				int b = Integer.parseInt(range[range.length - 1]);
				while(a <= b) {
					sb.append(a).append(", ");
					a++;
				}
			} else {
				sb.append(words[i]).append(", ");
			}
		}
		
		System.out.println(sb.toString());
	}

	private static void expand(String str) {
		String[] sp = str.split("\\-");
		String res = "";
		for (int i = 0; i < sp.length; i++) {
			if (i != sp.length - 1) {
				String[] a1 = sp[i].split(", ");
				String[] a2 = sp[i + 1].split(", ");
				int a = Integer.parseInt(a1[a1.length - 1]);
				int b = Integer.parseInt(a2[0]);
				for (int j = a + 1; j < b; j++) {
					sp[i] = sp[i] + ", " + j;
				}
			}
			if (res != "")
				res = res + ", " + sp[i];
			else
				res = sp[i];
		}
		System.out.println(res);
	}
}
