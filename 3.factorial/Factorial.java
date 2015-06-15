package factorial;

import java.math.BigInteger;

public class Factorial {

	public static void main(String[] args) {
		int max = 100;
		BigInteger n = f(max);
		System.out.println(sum(n));
	}

	/*
	 * method returns the sum of digits in a number
	 * 
	 * @param n - number to count the sum of digits from
	 */
	public static BigInteger sum(BigInteger n) {
		BigInteger result = BigInteger.ZERO;

		while (!n.equals(BigInteger.ZERO)) {
			result = result.add(n.mod(BigInteger.TEN));
			n = n.divide(BigInteger.TEN);
		}
		return result;
	}

	/*
	 * method returns the factorial of a number
	 * 
	 * @param n - number to be counted
	 */
	public static BigInteger f(int n) {
		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= n; ++i) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
}