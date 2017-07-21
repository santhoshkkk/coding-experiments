package algo.impl;

import java.util.Scanner;

public class Divide {
	static int getTotalX(int[] a, int[] b) {
		int count = 0;
		// Complete this function
		int max = -1;
		for (int i = 0; i < b.length; i++) {
			if (b[i] > max) {
				max = b[i];
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}

		for (int i = min; i <= max; i++) {
			boolean valid = true;
			inner1: for (int j = 0; j < a.length; j++) {
				if (i % a[j] != 0) {
					valid = false;
					break inner1;
				}
			}
			if (!valid) {
				continue;
			}
			inner2: for (int j = 0; j < b.length; j++) {
				if (b[j] % i != 0) {
					valid = false;
					break inner2;
				}
			}
			if (valid) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int[] b = new int[m];
		for (int b_i = 0; b_i < m; b_i++) {
			b[b_i] = in.nextInt();
		}
		int total = getTotalX(a, b);
		System.out.println(total);
	}

}
