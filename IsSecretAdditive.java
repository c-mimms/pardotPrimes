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

		List<Integer> primes = getPrimes(inputNumber);

		// TODO
		// create a map or array to store returned values of secret?

		Iterator<Integer> primeIterator = primes.iterator();
		while (primeIterator.hasNext()) {
			int prime = primeIterator.next();
			// Save this so we don't call secret unnecessarily
			int secret1 = secret(prime);
			// First prime was removed from iterator and needs to be checked
			// against itself.
			if (secret1 * 2 != secret(prime + prime)) {
				System.out.println("Secret is not additive!");
				System.exit(0);
			}
			primeIterator.forEachRemaining(prime2 -> {
				if (secret1 + secret(prime2) != secret1 + secret(prime2)) {
					System.out.println("Secret is not additive!");
					System.exit(0);
				}
			});
			primeIterator.remove();
		}
		System.out.println("Secret is additive.");

	}

	/**
	 * @param maxNum
	 * @return A list of primes up to the maxNum.
	 */
	public static List<Integer> getPrimes(int maxNum) {
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

	private static int secret(int n) {
		if (n == 4) {
			return 3;
		} else
			return n;
	}
}