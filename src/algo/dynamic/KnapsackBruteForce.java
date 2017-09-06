package algo.dynamic;

import java.util.Scanner;

public class KnapsackBruteForce {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int w = s.nextInt();

		int[] ws = new int[n];
		for (int i = 0; i < n; i++) {
			ws[i] = s.nextInt();
		}

		int[] vs = new int[n];
		for (int i = 0; i < n; i++) {
			vs[i] = s.nextInt();
		}

		int maxV = knapSack(n, w, ws, vs);
		System.out.println(maxV);
		s.close();
	}

	private static int knapSack(int n, int w, int[] ws, int[] vs) {
		if (0 == w || 0 == n) {
			return 0;
		}

		if (ws[n - 1] > w) {
			return knapSack(n - 1, w, ws, vs);
		}

		return max(knapSack(n - 1, w, ws, vs), vs[n - 1] + knapSack(n - 1, w - ws[n - 1], ws, vs));
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
