package org.datastructures.arrays.rotation;

public class PairSum {
	// Here Array is sorted and rotated, also distinct elements
	public static int[] arr = { 5, 6, 8, 9, 10 };

	public static void main(String[] args) {
		int[] ar1 = new int[arr.length];
		System.arraycopy(arr, 0, ar1, 0, arr.length);
		int x = 30;
		boolean pairAvailable = isPairAvailable(ar1, ar1.length, x);
		System.out.println("Does pair available? " + pairAvailable);
		
		int count = pairCount(ar1, ar1.length, x);
		System.out.println("Pair count? " + count);
	}

	private static boolean isPairAvailable(int[] arr, int n, int x) {
		// Find the pivot element
		int i;
		for (i = 0; i < n - 1; i++)
			if (arr[i] > arr[i + 1])
				break;

		int l = (i + 1) % n; // l is now index of
								// smallest element

		int r = i; // r is now index of largest
					// element

		// Keep moving either l or r till they meet
		while (l != r) {
			// If we find a pair with sum x, we
			// return true
			if (arr[l] + arr[r] == x)
				return true;

			// If current pair sum is less, move
			// to the higher sum
			if (arr[l] + arr[r] < x)
				l = (l + 1) % n;

			else // Move to the lower sum side
				r = (n + r - 1) % n;
		}
		return false;
	}

	private static int pairCount(int[] arr, int n, int x) {

		int i;
		for (i = 0; i < n - 1; i++) {
			if (arr[i + 1] < arr[i])
				break;
		}

		int l = (i + 1) % n;
		int r = i;

		int cnt = 0;

		while (l != r) {
			if (arr[l] + arr[r] == x) {
				cnt++;
				// This condition is required  
	            // to be checked, otherwise  
	            // l and r will cross each  
	            // other and loop will never  
	            // terminate. 
	            if(l == (r - 1 + n) % n) 
	            { 
	                return cnt; 
	            } 
	              
	            l = (l + 1) % n; 
	            r = (r - 1 + n) % n; 
			}

			if (arr[l] + arr[r] < x)
				l = (l + 1) % n;
			else
				r = (n + r - 1) % n;
		}

		return cnt;
	}

}
