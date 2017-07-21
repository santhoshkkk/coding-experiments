package algo.impl;

import java.util.Scanner;

public class DenseRank {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] scores = new int[n];
		int len = 0;
		int prev = -1;
		int num = -1;
		for (int scores_i = 0; scores_i < n; scores_i++) {
			num = in.nextInt();
			if (num != prev) {
				scores[len++] = num;
			}
			prev = num;
		}

		int m = in.nextInt();
		int[] alice = new int[m];
		for (int alice_i = 0; alice_i < m; alice_i++) {
			alice[alice_i] = in.nextInt();
		}
		// your code goes here
		for (int i = 0; i < alice.length; i++) {
			printRank(scores, len, alice[i]);
		}
		in.close();
	}

	private static void printRank(int[] scores, int len, int score) {
		int rank = len + 1;
		int start = 0;
		int end = len - 1;
		while (true) {
			int mid = getMid(start, end);
			if (scores[mid] == score) {
				while (--mid >= 0 && scores[mid] == score)
					;
				rank = mid + 2;
				break;
			} else if (score > scores[mid]) {
				if (0 != mid && score < scores[mid - 1]) {
					rank = mid + 1;
					break;
				} else {
					end = mid - 1;
				}
			} else {
				if (mid != len - 1 && score > scores[mid + 1]) {
					rank = mid + 2;
					break;
				} else {
					start = mid + 1;
				}
			}
			if (start > end) {
				if (scores[0] < score) {
					rank = 1;
				}
				break;
			}
		}
		System.out.println(rank);
	}

	private static int getMid(int start, int end) {
		int mid = 0;
		int sum = start + end;
		if (sum % 2 == 1) {
			mid = (sum + 1) / 2;
		} else {
			mid = sum / 2;
		}
		return mid;
	}
}
