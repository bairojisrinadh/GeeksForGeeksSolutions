package org.geeksforgeeks.strings;

import java.util.Stack;

public class MaxValUsingOperator {
	public static void main(String[] args) {
		String s = "01891";
		// int max = getMax(s);
		// int max = getMaxUsingStack(s);
		int max = getMaxGFG(s);
		System.out.println(max);
	}

	private static int getMaxGFG(String s) {

		int res = s.charAt(0) - '0';

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '0' || s.charAt(i) == '1' || res < 2) {
				res += (s.charAt(i) - '0');
			} else {
				res *= (s.charAt(i) - '0');
			}
		}

		return res;
	}

	private static int getMaxUsingStack(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = s.length() - 1; i >= 0; i--) {
			stack.push(s.charAt(i) - '0');
		}

		while (!stack.isEmpty()) {
			if (stack.size() == 1) {
				return stack.pop();
			}
			int o1 = stack.pop();
			int o2 = stack.pop();
			if (o1 == 0 || o1 == 1 || o2 == 0 || o2 == 1) {
				stack.push(o1 + o2);
			} else {
				stack.push(o1 * o2);
			}
		}

		return -1;
	}

	/*
	 * private static int getMax(String s) {
	 * char op = '0';
	 * int max = 0;
	 * for (int i = 0; i < s.length() - 1; i++) {
	 * char o1 = s.charAt(i);
	 * char o2 = s.charAt(i + 1);
	 * if(o1 == '0' || o1 == '1' || o2 == '0' || o2 == '1') {
	 * op = '+';
	 * } else {
	 * op = '*';
	 * }
	 * if(op != '0') {
	 * int l1 = (int) (o1 - '0');
	 * int l2 = (int) (o2 - '0');
	 * if(op == '+') {
	 * max += l1 + l2;
	 * } else if(op == '*') {
	 * max += (l1 * l2);
	 * }
	 * //reset op
	 * op = '0';
	 * }
	 * }
	 * return max;
	 * }
	 */
}
