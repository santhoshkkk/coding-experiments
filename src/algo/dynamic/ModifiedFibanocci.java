package algo.dynamic;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ModifiedFibanocci {
	private static Map<Integer, BigInteger> fibs = new HashMap<>();

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);

		int t1 = s.nextInt();
		fibs.put(1, new BigInteger(t1 + ""));
		int t2 = s.nextInt();
		fibs.put(2, new BigInteger(t2 + ""));
		int n = s.nextInt();

		System.out.println(modfib(n));

		s.close();
	}

	private static BigInteger modfib(int n) {
		BigInteger fibn = fibs.get(n);
		if (null == fibn) {
			BigInteger tn2 = modfib(n - 2);
			BigInteger tn1 = modfib(n - 1);
			fibn = tn2.add(tn1.multiply(tn1));
			fibs.put(n, fibn);
		}
		return fibn;

	}

}
