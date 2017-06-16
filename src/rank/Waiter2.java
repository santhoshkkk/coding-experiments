package rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Waiter2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int Q = s.nextInt();
		int[] A0 = new int[N];
		for (int i = 0; i < N; i++) {
			A0[i] = s.nextInt();
		}

		int[] primes = findQPrimes(Q);

		Stack<Integer> current = new Stack<>();
		for (int i = 0; i < N; i++) {
			current.push(A0[i]);
		}

		List<Stack<Integer>> Bs = new ArrayList<>();
		Stack<Integer> next = null;
		Stack<Integer> Bi = null;
		for (int i = 0; i < Q; i++) {
			if (0 == current.size()) {
				break;
			}
			next = new Stack<Integer>();
			Bi = new Stack<Integer>();
			Bs.add(Bi);
			while (!current.isEmpty()) {
				int elem = current.pop();
				if (elem % primes[i] == 0) {
					Bi.push(elem);
				} else {
					next.push(elem);
				}
			}

			current = next;
		}

		for (Stack<Integer> B : Bs) {
			while (!B.isEmpty()) {
				System.out.println(B.pop());
			}
		}

		while (!next.isEmpty()) {
			System.out.println(next.pop());
		}

		s.close();
	}

	private static int[] findQPrimes(int q) {
		int[] primes = new int[q];
		int count = 0;
		int num = 2;
		while (count < q) {
			if (isPrime(num)) {
				primes[count++] = num;
			}
			num++;
		}
		return primes;
	}

	private static boolean isPrime(int num) {
		int maxDiv = (int) Math.sqrt(num);
		boolean prime = true;
		for (int i = 2; i <= maxDiv; i++) {
			if (num % i == 0) {
				prime = false;
			}
		}
		return prime;
	}

}
