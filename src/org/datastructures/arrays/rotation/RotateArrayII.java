package org.datastructures.arrays.rotation;

import static org.utilities.ArrayUtils.printArray;
import static org.utilities.ArrayUtils.reverse;

public class RotateArrayII {

	public static int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

	public static void main(String[] args) {
		int[] ar1 = new int[arr.length];
		System.arraycopy(arr, 0, ar1, 0, arr.length);
		// arrayRotationUsingReversal(ar1, ar1.length, 6);
		arrayRotationUsingBlockSwap(ar1, ar1.length, 2);
	}

	/**
	 * 
	 * @param Array  itself
	 * @param length of an array
	 * @param no.    of rotations
	 * 
	 *               Initialize A = arr[0..d-1] and B = arr[d..n-1] 1) Do following until size of A is equal to size of B
	 * 
	 *               a) If A is shorter, divide B into Bl and Br such that Br is of same length as A. Swap A and Br to change ABlBr into BrBlA. Now A is
	 *               at its final place, so recur on pieces of B.
	 * 
	 *               b) If A is longer, divide A into Al and Ar such that Al is of same length as B Swap Al and B to change AlArB into BArAl. Now B is at
	 *               its final place, so recur on pieces of A.
	 * 
	 *               2) Finally when A and B are of equal size, block swap them.
	 * 
	 */
	private static void arrayRotationUsingBlockSwap(int[] arr, int n, int d) {
		if (d == 0 || d == n)
			return;
		int i = d;
		int j = n - d;

		while (i != j) {
			// A is shorter
			if (i < j) {
				swap(arr, d - i, d + j - i, i);
				System.out.println("i < j: i.e., " + i + " < " + j + ": " + printArray(arr));
				j = j - i;
			} else { //B is shorter
				swap(arr, d - i, d, j);
				System.out.println("i < j: i.e., " + i + " > " + j + ": " + printArray(arr));
				i = i - j;
			}
		}
		swap(arr, d - i, d, i);
		System.out.println("Final: " + printArray(arr));
	}

	private static void swap(int[] arr, int fi, int si, int d) {
		if (fi == si)
			return;
		int temp;
		for (int i = 0; i < d; i++) {
			temp = arr[fi + i];
			arr[fi + i] = arr[si + i];
			arr[si + i] = temp;
		}
	}

	private static void arrayRotationUsingReversal(int[] arr, int n, int d) {
		// if no. of rotations equals array length itself, then all elements will be initial places itself.
		if (d == n) {
			System.out.println("After " + d + " rotations: " + printArray(arr));
			return;
		}

		reverse(arr, 0, d - 1);
		reverse(arr, d, n - 1);
		reverse(arr, 0, n - 1);
		System.out.println("After " + d + " rotations: " + printArray(arr));
	}

}
