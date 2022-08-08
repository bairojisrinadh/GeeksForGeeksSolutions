package org.datastructures.arrays.rotation;

import static org.utilities.ArrayUtils.printArray;

public class MaxSumWhileRotatingArray {

	// Here Array is sorted and rotated, also distinct elements
	public static int[] arr = { 7, 1, 2, 3, 4, 5, 6, 7, 8, 19 };

	public static void main(String[] args) {
		int[] ar1 = new int[arr.length];
		System.arraycopy(arr, 0, ar1, 0, arr.length);
		int[] ar2 = new int[arr.length];
		System.arraycopy(arr, 0, ar2, 0, arr.length);
		long maxSum = getMaxSum(ar1, ar1.length);
		System.out.println("Max Sum: " + maxSum);
		long maxSum1 = maxSum(ar1, ar1.length);
		System.out.println("Max Sum1: " + maxSum1);
	}

	//Wrong solution
	private static long getMaxSum(int[] arr, int n) {
		int maxElementIndex = 0;
		int i;
		for (i = 1; i < n; i++) {// O(n)
			if (arr[i] > arr[maxElementIndex])
				maxElementIndex = i;
		}

		int d = maxElementIndex + 1;
		if (d != n) {
			int temp;
			while (d-- > 0) {
				temp = arr[0];
				for (i = 0; i < n - 1; i++) {// O(dn)
					arr[i] = arr[i + 1];
				}
				arr[n - 1] = temp;
			}
			System.out.println("After " + (maxElementIndex + 1) + " rotations: " + printArray(arr));
		}

		int maxSum = 0;
		for (i = 0; i < n; i++) {// O(n)
			maxSum += i * arr[i];
		}

		return maxSum;
		// Total Time Complexity: O(n) + O(dn) + O(n) ~= O(n)
	}

	//GFG Solution
	private static int maxSum(int[] arr, int n) {
		// Find array sum and i*arr[i] with no rotation
		int arrSum = 0; // Stores sum of arr[i]
		int currVal = 0; // Stores sum of i*arr[i]
		for (int i = 0; i < arr.length; i++) {
			arrSum = arrSum + arr[i];
			currVal = currVal + (i * arr[i]);
		}

		// Initialize result as 0 rotation sum
		int maxVal = currVal;

		// Try all rotations one by one and find
		// the maximum rotation sum.
		for (int j = 1; j < arr.length; j++) {
			currVal = currVal + arrSum - arr.length * arr[arr.length - j];
			if (currVal > maxVal)
				maxVal = currVal;
		}

		// Return result
		return maxVal;
	}
}
