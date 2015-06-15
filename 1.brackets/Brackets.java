package brackets;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Brackets {

	public static void main(String[] args) {
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the number of opening and closing brackets: ");
			try {
				int n = input.nextInt();
				if (n >= 0) {
					System.out.print("Possible expressions: ");
					System.out.println(c(n));
				} else {
					System.out.println("Wrong input!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Wrong input!");
			}
		}
	}

	/*
	 * method returns number of possible expressions with brackets
	 * 
	 * @param n - number of opening and closing brackets
	 */
	public static BigInteger c(int n) {
		BigInteger result = BigInteger.ONE;
		if (n <= 1) {
			return result;
		}

		for (int i = 0; i < n; i++) {
			result = result.add(c(i).multiply(c(n - i - 1))); // recursively counts all possible variants
		}
		return result;
	}

}
