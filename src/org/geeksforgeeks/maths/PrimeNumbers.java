package org.geeksforgeeks.maths;

public class PrimeNumbers {

	public static void main(String[] args) {
		int n = 100;
		//printAllPrimes(n);
		sieveOfEratosthenes(n);
	}

	private static void sieveOfEratosthenes(int n) {
		boolean[] primes = new boolean[n + 1];
		for (int i = 2; i < n + 1; i++)
			primes[i] = true;

		for (int i = 2; i * i <= n; i++) {
			if (primes[i] == true) {
				for (int j = 2; i * j <= n; j++) {
					primes[i * j] = false;
				}
			}
		}

		for (int i = 2; i < n + 1; i++) {
			if (primes[i] == true)
				System.out.println(i + " ");
		}
	}

	// Total Time Complexity is O(n * sqrt(n))
	private static void printAllPrimes(int n) {
		if (n < 2)
			System.out.println("Not a valid prime number");

		for (int i = 2; i <= n; i++) { // O(n * sqrt(n))
			if (isPrime(i)) // O(sqrt(n))
				System.out.println(i + " ");
		}
	}

	private static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) { // O(sqrt(n))
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
