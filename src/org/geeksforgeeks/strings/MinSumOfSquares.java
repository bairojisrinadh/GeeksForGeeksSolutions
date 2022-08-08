package org.geeksforgeeks.strings;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinSumOfSquares {

	private static final int MAX_VAL = 26;

	public static void main(String[] args) {
		String str = "abbcccdddd";
		int k = 5;
//		int res = minSumOfSq(str, k);
		int res = minSumOfSqGFG(str, k);
		System.out.println(res);
	}

	private static int minSumOfSqGFG(String str, int k) {
		int l = str.length();
		
		if(k > l)
			return 0;
		
		int[] frequency = new int[MAX_VAL];
		for(int i = 0; i < l; i++) {
			frequency[str.charAt(i) - 'a']++;
		}
		
		Comparator<Integer> c = new IntCompare();
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(c);
		
		for(int i = 0; i < MAX_VAL; i++) {
			if(frequency[i] != 0)
				q.add(frequency[i]);
		}
		
		while(k != 0) {
			// Get top element in priority_queue, 
            // remove it. Decrement by 1 and again 
            // push into priority_queue 
            int temp = q.peek(); 
            q.poll(); 
            temp = temp-1; 
            q.add(temp); 
            k--; 
		}
		
		int res = 0;
		while(!q.isEmpty()) {
			int temp = q.peek(); 
            res += temp*temp; 
            q.poll();
		}
		
		return res;
	}
	
	static class IntCompare implements Comparator<Integer>{ 
        @Override
        public int compare(Integer arg0, Integer arg1) { 
            if(arg0 > arg1) 
                return -1; 
            else if(arg0 < arg1) 
                return 1; 
            else
                return 0; 
        } 
    } 

	private static int minSumOfSq(String str, int offset) {
		int res = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] ch = str.toCharArray();
		for(int i = 0; i < ch.length; i++) {
			char key = ch[i];
			if(map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		
		//sort map in descending order of values
		List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());
		Collections.sort(list, (o1, o2) -> -1 * (o1.getValue().compareTo(o2.getValue())));
		
		map = new LinkedHashMap<Character, Integer>();
		
		for(Map.Entry<Character, Integer> e: list) {
			map.put(e.getKey(), e.getValue());
		}
		
		for(Map.Entry<Character, Integer> e: map.entrySet()) {
			if(e.getValue() > offset) {
				e.setValue(e.getValue() - offset);
				break;
			} else {
				offset -= e.getValue();
				e.setValue(0);
			}
		}
		
		for(int e : map.values()) {
			res += e * e;
		}
		
		return res;
	}
}
