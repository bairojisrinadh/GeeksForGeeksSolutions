package org.utilities;

public class ArrayUtils {

	public static void reverse(int[] arr) throws ArrayIndexOutOfBoundsException {
		reverse(arr, 0, arr.length - 1);
	}

	public static void reverse(int[] arr, int startIndex, int endIndex) throws ArrayIndexOutOfBoundsException {
		if (arr == null)
			throw new NullPointerException("Provided array is null referencing");

		if (startIndex < 0 || endIndex > arr.length - 1)
			throw new ArrayIndexOutOfBoundsException();

		if (arr.length == 1 || startIndex == endIndex)
			return;

		while (startIndex < endIndex) {
			// swap
			int temp = arr[startIndex];
			arr[startIndex] = arr[endIndex];
			arr[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
	}

	public static String printArray(int[] ar) throws ArrayIndexOutOfBoundsException {
		return printArrayFrmIndex(ar, 0);
	}

	public static String printArrayFrmIndex(int[] ar, int index) throws ArrayIndexOutOfBoundsException {
		if (ar == null)
			throw new NullPointerException("Provided array is null referencing");

		if (index < 0 || index > ar.length - 1)
			throw new ArrayIndexOutOfBoundsException();

		StringBuilder sb = new StringBuilder();
		int i = index;

		sb.append("{");
		while (true) {
			if (i == ar.length - 1)
				return sb.append(ar[i]).append("}").toString();
			sb.append(ar[i]).append(", ");
			i++;
		}
	}

}
