package org.geeksforgeeks.strings;

public class ProductAtKthLevel {

	public static void main(String[] args) {
		String s = "(8(3(2()())(6(5()())()))(5(10()())(7(1()())(3()()))))";
		int product = getProduct(s, 3);
		System.out.println(product);
	}

	private static int getProduct(String s, int k) {
		int level = -1, product = 1;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '(')
				level++;
			else if(ch == ')')
				level--;
			else if(level == k)
				product *= (ch - '0');
		}
		
		return product;
	}
}
