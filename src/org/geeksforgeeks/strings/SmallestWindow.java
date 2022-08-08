package org.geeksforgeeks.strings;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindow {

	public static void main(String[] args) {
		String s = "dbcaaabcbc";
		String res = getSmallWindow(s);
		System.out.println(res);
	}

	private static String getSmallWindow(String s) {
		int n = s.length();
		
		int dist_count = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if(map.get(ch) == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}
		
		dist_count = map.size();
		int size = Integer.MAX_VALUE;
		String res = "";
		
		for(int i = 0; i < n; i++) {
			int count = 0;
			int visited[] = new int[256];
			String sub_str = "";
			for (int j = i; j < n; j++) { 
	            if (visited[s.charAt(j)] == 0) { 
	                count++; 
	                visited[s.charAt(j)] = 1; 
	            } 
	            sub_str += s.charAt(j); 
	            if (count == dist_count) 
	                break; 
	        } 
	        if (sub_str.length() < size && count == dist_count) 
	            res = sub_str; 
		}
		return res;
	}
}
