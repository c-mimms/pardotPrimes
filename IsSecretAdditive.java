import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris
 *
 */
public class IsSecretAdditive {

	public static void main(String[] args) {
		
		//Parse parameter and ensure it is an integer.
		int inputNumber = 0;
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
		

		List<Integer> primes = getPrimes(inputNumber);
		
		//TODO
		//	create a map or array to store returned values of secret?
		//	loop through array of primes
		//		print false if not additive

	}
	
	/**
	 * @param maxNum
	 * @return A list of primes up to the maxNum.
	 */
	public static List<Integer> getPrimes(int maxNum){
		//Size list appropriately estimating number of primes.
		List<Integer> primeList = new ArrayList((int) (maxNum/Math.log(maxNum)));
		
		//Add low primes manually.
		primeList.add(2);
        primeList.add(3);
        primeList.add(5);
        primeList.add(7);

        //Mark all multiples as non-primes
        for (int i = 11; i <= maxNum; i+=2) {
        	boolean prime = true;
            for (int j = 3; j*j < i; j++) {
                if(i%j == 0){
                	prime = false;
                	break;
                }
            }
            if (prime){
            	primeList.add(i);
            }
        }
        return primeList;
	}

	private int secret(int n) {
		return n + 1;
	}
}