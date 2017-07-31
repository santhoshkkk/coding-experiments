package algo.constructive;

import java.util.Scanner;

public class FlapTheMatrix {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
		int n = 0;
		int[][] arr;
		int n2 = 0;
		int sum = 0;
		for (int i = 0; i < q; i++) {
			n = s.nextInt();
			n2 = n * 2;
			arr = new int[n2][n2];
			sum = 0;
			for (int j = 0; j < n2; j++) {
				for (int k = 0; k < n2; k++) {
					arr[j][k] = s.nextInt();
				}
			}

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					int i1 = (n2 - 1) - i;
					int j1 = (n2 - 1) - j;
					sum += max(arr[i][j], arr[i1][j], arr[i][j1], arr[i1][j1]);
				}
			}
			System.out.println(sum);
		}
		s.close();
	}

	private static int max(int i, int j, int k, int l) {
		int max;
		if (i > j)
			if (i > k)
				if (i > l)
					max = i;
				else
					max = l;
			else if (k > l)
				max = k;
			else
				max = l;
		else if (j > k)
			if (j > l)
				max = j;
			else
				max = l;

		else if (k > l)
			max = k;
		else
			max = l;
		return max;
	}

}
