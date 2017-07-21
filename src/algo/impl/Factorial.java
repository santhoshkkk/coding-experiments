package algo.impl;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		BigInteger factorial = new BigInteger("1");
		while (n > 0) {
			factorial = factorial.multiply(new BigInteger(n + ""));
			n--;
		}
		System.out.println(factorial);
		in.close();
	}
}
