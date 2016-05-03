import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Chris
 *
 */
public class IsSecretAdditive {

	public static void main(String[] args) {

		// Parse parameter and ensure it is an integer.
		int inputNumber = 0;
		if (args.length > 0) {
			try {
				inputNumber = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Input must be an integer.");
				System.exit(1);
			}
		} else {
			System.out.print("Must call with an integer argument.");
			System.exit(1);
		}

		List<Integer> primes = getPrimes2(inputNumber);

		// TODO
		// create a map or array to store returned values of secret?

		int numPrimes = primes.size();
		for (int i = 0; i < numPrimes; i++) {

			// Save this so we don't call secret unnecessarily
			int prime1 = primes.get(i);
			int secret1 = secret(prime1);
			for (int j = i; j < numPrimes; j++) {
				int prime2 = primes.get(j);
				int secret2 = secret(prime2);
				if (secret1 + secret2 != secret(prime1 + prime2)) {
					System.out.println("Secret is not additive!");
					System.exit(0);
				}
			}

		}
		System.out.println("Secret is additive.");

	}

	/**
	 * @param maxNum
	 * @return A list of primes up to the maxNum.
	 */
	private static List<Integer> getPrimes(int maxNum) {
		// Size list appropriately estimating number of primes.
		List<Integer> primeList = new ArrayList((int) (maxNum / Math.log(maxNum)));

		// Add low primes manually.
		primeList.add(2);
		primeList.add(3);
		primeList.add(5);
		primeList.add(7);

		// Mark all multiples as non-primes
		for (int i = 11; i <= maxNum; i += 2) {
			boolean prime = true;
			// Only check against previously generated primes
			for (int primeNum : primeList) {
				if (i % primeNum == 0) {
					prime = false;
					break;
				}
				if (primeNum * primeNum > i) {
					break;
				}
			}
			if (prime) {
				primeList.add(i);
			}
		}
		return primeList;
	}

	/**
	 * 
	 * @param maxNum
	 * @return A list of primes up to the maxNum.
	 */
	private static List<Integer> getPrimes2(int maxNum) {

		// We assume even numbers are not prime
		boolean[] isPrime = new boolean[maxNum / 2 + 1];
		for (int i = 0; i <= isPrime.length - 1; i++) {
			isPrime[i] = true;
		}

		// Mark all multiples as non-primes
		// Eliminate evens
		for (int i = 1; (i * 2) + 1 <= Math.sqrt(maxNum); i++) {
			if (isPrime[i]) {
				int n = i * 2 + 1;
				for (int j = n; n * j <= maxNum; j += 2) {
					int index = ((j * n) - 1) / 2;
					isPrime[index] = false;
				}
			}
		}

		// Size list appropriately by estimating the number of primes below the
		// given number
		List<Integer> primeList = new ArrayList((int) (maxNum / Math.log(maxNum)));
		
		// Because we eliminated all evens we treat 2 as a special case and add
		// it manually
		primeList.add(2);
		for (int i = 1; i < isPrime.length; i++) {
			// Eliminating evens resulted in 2 and 3 being treated identically,
			// we need to exit early if called with 2
			if (maxNum == 2)
				break;
			if (isPrime[i]) {
				primeList.add(i * 2 + 1);
			}
		}
		return primeList;
	}

	/**
	 * Test function
	 * @param n
	 * @return A function of n.
	 */
	private static int secret(int n) {
		if (n == 6) {
			return 3;
		} else
			return n;
	}
}