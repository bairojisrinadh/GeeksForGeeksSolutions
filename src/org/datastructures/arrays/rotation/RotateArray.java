package org.datastructures.arrays.rotation;

import static org.utilities.ArrayUtils.printArray;
import static org.utilities.NumberUtils.gcd;

public class RotateArray {

	public static int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
	public static int[] arr12 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

	public static void main(String[] args) {
		int[] ar1 = new int[arr.length];
		System.arraycopy(arr, 0, ar1, 0, arr.length);
		arrayRotationUsingTemp(ar1, ar1.length, 7);

		int[] ar2 = new int[arr.length];
		System.arraycopy(arr, 0, ar2, 0, arr.length);
		rotateInPlace(ar2, ar2.length, 6);

		int[] ar3 = new int[arr.length];
		System.arraycopy(arr, 0, ar3, 0, arr.length);
		jugglingAlgo(ar3, ar3.length, 2);
	}

	/**
	 * 
	 * @param arr, Array itself
	 * @param n,   Array Length
	 * @param d,   No. of positions to be rotated
	 */
	private static void arrayRotationUsingTemp(int[] arr, int n, int d) {
		// if no. of rotations equals array length itself, then all elements will be initial places itself.
		if (d == n) {
			System.out.println("After " + d + " rotations: " + printArray(arr));
			return;
		}

		int[] temp = new int[d];
		int i;
		for (i = 0; i < d; i++) { // O(d)
			temp[i] = arr[i];
		}

		int start;
		for (start = d, i = 0; start < n; i++, start++) { // O(n)
			arr[i] = arr[start];
		}

		int rotateStartIndex;
		for (i = 0, rotateStartIndex = n - d; i < d; i++, rotateStartIndex++) { // O(d)
			arr[rotateStartIndex] = temp[i];
		}

		System.out.println("After " + d + " rotations: " + printArray(arr));

		// TimeComplexity = O(d) + O(n) + O(d) ~= O(n)
		// SpaceComplexity Or Auxiliary Space = O(d)
	}

	private static void rotateInPlace(int[] arr, int n, int d) {
		// if no. of rotations equals array length itself, then all elements will be initial places itself.
		if (d == n) {
			System.out.println("After " + d + " rotations: " + printArray(arr));
			return;
		}

		int rotations = d;
		while (rotations-- > 0) {
			int temp = arr[0];
			for (int i = 0; i < n - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[n - 1] = temp;
		}

		System.out.println("After " + d + " rotations: " + printArray(arr));
	}

	private static void jugglingAlgo(int[] arr, int n, int d) {
		// if no. of rotations equals array length itself, then all elements will be initial places itself.
		if (d == n) {
			System.out.println("After " + d + " rotations: " + printArray(arr));
			return;
		}

		/* To handle if d >= n */
		d = d % n;

		int gcd = gcd(n, d);
		int i, j, k, temp;
		for (i = 0; i < gcd; i++) {
			temp = arr[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
		
		System.out.println("After " + d + " rotations: " + printArray(arr));
	}
}
