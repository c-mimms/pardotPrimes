import java.util.List;

/**
 * @author Chris
 *
 */
public class IsSecretAdditive {

	public static void main(String[] args) {
		
		//Parse parameter and ensure it is an integer.
		int inputNumber;
		if (args.length > 0) {
			try {
				inputNumber = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Input must be an integer.");
				System.exit(1);
			}
		}
		else {
			System.out.print("Must call with an integer argument.");
			System.exit(1);
		}
		
		//TODO
		//	generate list of primes up to args[0]
		//	create a map or array to store returned values of secret?
		//	loop through array of primes
		//		print false if not additive

	}
	
	/**
	 * @param maxNum
	 * @return A list of primes up to the maxNum.
	 */
	public static List<Integer> getPrimes(int maxNum){
		return null;
	}

	private int secret(int n) {
		return n + 1;
	}
}