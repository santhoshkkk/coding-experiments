package algo.impl;

import java.util.Scanner;

public class BreakRecord {

	static int[] getRecord(int[] s) {
		int min = Integer.MAX_VALUE;
		int max = -1;
		int[] records = new int[2];

		for (int i = 0; i < s.length; i++) {
			if (max < s[i]) {
				max = s[i];
				if (i != 0) {
					records[0]++;
				}
			}
			if (min > s[i]) {
				min = s[i];
				if (i != 0) {
					records[1]++;
				}
			}
		}
		return records;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] s = new int[n];
		for (int s_i = 0; s_i < n; s_i++) {
			s[s_i] = in.nextInt();
		}
		int[] result = getRecord(s);
		String separator = "", delimiter = " ";
		for (Integer val : result) {
			System.out.print(separator + val);
			separator = delimiter;
		}
		System.out.println("");
		in.close();
	}

}
