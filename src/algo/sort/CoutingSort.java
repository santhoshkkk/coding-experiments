package algo.sort;

import java.util.Scanner;

public class CoutingSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count[] = new int[100];
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			count[num]++;
		}

		for (int i = 0; i < 100; i++) {
			for (int c = 0; c < count[i]; c++) {
				System.out.print(i + " ");
			}
		}

		in.close();
	}

}
