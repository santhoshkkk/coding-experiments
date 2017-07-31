package algo.sort;

import java.util.Scanner;

public class StableCoutingSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count[] = new int[100];
		String[] origStr = new String[n];
		int[] origNum = new int[n];
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			count[num]++;
			origNum[i] = num;
			origStr[i] = in.next();
		}

		int half = n / 2;
		StringBuilder sb = new StringBuilder(100000);
		for (int i = 0; i < 100; i++) {
			if (count[i] > 0) {
				for (int j = 0; j < n; j++) {
					if (origNum[j] == i) {
						if (j < half)
							sb.append("-");
						else
							sb.append(origStr[j]);
						sb.append(" ");
					}
				}
			}
		}
		System.out.print(sb.toString());

		in.close();
	}

}
