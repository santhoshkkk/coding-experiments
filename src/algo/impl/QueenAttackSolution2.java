package algo.impl;

import java.util.Scanner;

public class QueenAttackSolution2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int rQ = in.nextInt();
		int cQ = in.nextInt();

		int c9 = 0;
		int r10 = 0;
		int c10 = 0;
		int r12 = 0;
		int r2 = 0;
		int c2 = n + 1;
		int c3 = n + 1;
		int r5 = n + 1;
		int c5 = n + 1;
		int r6 = n + 1;
		int r7 = n + 1;
		int c7 = 0;
		for (int a0 = 0; a0 < k; a0++) {
			int rO = in.nextInt();
			int cO = in.nextInt();
			// your code goes here

			if (rQ == rO) {
				if (cQ > cO && c9 < cO) {// 9 O clock
					c9 = cO;
				} else if (cQ < cO && c3 > cO) {// 3 O clock
					c3 = cO;
				}
			} else if (cQ == cO) {
				if (rQ > rO && r12 < rO) {
					r12 = rO;
				} else if (rQ < rO && r6 > rO) {
					r6 = rO;
				}
			} else {
				if (rQ > rO) { // top
					int y = rQ - rO;
					if (cQ > cO) {// 10 O clock
						int x = cQ - cO;
						if (x == y && c10 < cO) {
							c10 = cO;
							r10 = rO;
						}
					} else {// 2 O clock
						int x = cO - cQ;
						if (x == y && c2 > cO) {
							r2 = rO;
							c2 = cO;
						}
					}
				} else { // bottom
					int y = rO - rQ;
					if (cQ > cO) { // 7 O clock
						int x = cQ - cO;
						if (x == y && cO > c7) {
							r7 = rO;
							c7 = cO;
						}
					} else { // 5 O clock
						int x = cO - cQ;
						if (x == y && cO < c5) {
							r5 = rO;
							c5 = cO;
						}
					}
				}
			}
		}
		if (c10 == 0 && r10 == 0) {
			int x = cQ - c10;
			int y = rQ - r10;
			if (x > y) {
				c10 = cQ - y;
			}
		}

		if (c2 == n + 1 && r2 == 0) {
			int x = c2 - cQ;
			int y = rQ - r2;
			if (x > y) {
				c2 = cQ + y;
			}
		}

		if (c5 == n + 1 && r5 == n + 1) {
			int x = c5 - cQ;
			int y = r5 - rQ;
			if (x > y) {
				c5 = cQ + y;
			}
		}

		if (c7 == 0 && r7 == n + 1) {
			int x = cQ - c7;
			int y = r7 - rQ;
			if (x > y) {
				c7 = cQ - y;
			}
		}

		int moves9 = (cQ - c9) - 1;
		int moves10 = (cQ - c10) - 1;
		int moves12 = (rQ - r12) - 1;
		int moves2 = (c2 - cQ) - 1;
		int moves3 = (c3 - cQ) - 1;
		int moves5 = (c5 - cQ) - 1;
		int moves6 = (r6 - rQ) - 1;
		int moves7 = (cQ - c7) - 1;
		int totalMoves = moves9 + moves10 + moves12 + moves2 + moves3 + moves5 + moves6 + moves7;
		System.out.println(totalMoves);
		in.close();
	}
}
