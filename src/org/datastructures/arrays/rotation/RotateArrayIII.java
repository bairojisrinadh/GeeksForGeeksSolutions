package org.datastructures.arrays.rotation;

import static org.utilities.ArrayUtils.printArray;

public class RotateArrayIII {

	public static int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

	public static void main(String[] args) {
		int[] ar1 = new int[arr.length];
		System.arraycopy(arr, 0, ar1, 0, arr.length);
		cyclicallyRotateInClockwise(ar1, ar1.length);
	}

	private static void cyclicallyRotateInClockwise(int[] arr, int n) {
		int temp = arr[n - 1];
		for (int i = n - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
		System.out.println(printArray(arr));
	}

}
