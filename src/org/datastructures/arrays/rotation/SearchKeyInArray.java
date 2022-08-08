package org.datastructures.arrays.rotation;

public class SearchKeyInArray {

	// Here Array is sorted and rotated, also distinct elements
	public static int[] arr = { 6, 7, 3, 4, 5, 1, 2 };

	public static void main(String[] args) {
		int[] ar1 = new int[arr.length];
		System.arraycopy(arr, 0, ar1, 0, arr.length);
		int key = 3;
		int index = searchKey(ar1, key);
		if(index != -1)
			System.out.println("Key found at index: " + index);
		else
			System.out.println("Key not found");
	}

	private static int searchKey(int[] arr, int key) {
		int n = arr.length;
		int pivot = findPivot(arr, 0, n - 1);

		if (pivot == -1)
			return binarySearch(arr, 0, n - 1, key);

		// If we found a pivot, then first
		// compare with pivot and then
		// search in two subarrays around pivot
		if (arr[pivot] == key)
			return pivot;
		if (arr[0] <= key)
			return binarySearch(arr, 0, pivot - 1, key);
		return binarySearch(arr, pivot + 1, n - 1, key);
	}

	private static int findPivot(int[] arr, int low, int high) {
		if (high < low)
			return -1;
		if (high == low)
			return low;

		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return mid - 1;
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);
	}

	private static int binarySearch(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;

		int mid = (low + high) / 2;
		if (key == arr[mid])
			return mid;
		if (key > arr[mid])
			return binarySearch(arr, (mid + 1), high, key);
		return binarySearch(arr, low, (mid - 1), key);
	}
}
