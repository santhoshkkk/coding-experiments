package algo;

import java.util.Scanner;

public class Grades {

	static int[] solve(int[] grades) {
		int diff = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] > 38) {
				diff = grades[i] % 5;
				if (diff > 2) {
					grades[i] = grades[i] + 5 - diff;
				}
			}
		}
		return grades;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] grades = new int[n];
		for (int grades_i = 0; grades_i < n; grades_i++) {
			grades[grades_i] = in.nextInt();
		}
		int[] result = solve(grades);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");
		in.close();
	}
}
