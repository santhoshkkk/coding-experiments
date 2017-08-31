package iview.uber;

import java.util.Scanner;

public class BudgetShopping {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int m = s.nextInt();
		int[] quant = new int[m];
		for (int i = 0; i < m; i++) {
			quant[i] = s.nextInt();
		}

		int sh = s.nextInt();
		int[] cost = new int[sh];
		for (int i = 0; i < sh; i++) {
			cost[i] = s.nextInt();
		}

		int[] books = new int[1];

		budgetShopping(n, quant, cost, m, books);
		System.out.println(books[0]);

	}

	static int budgetShopping(int MAX, int[] bundleQuantities, int[] bundleCosts, int n, int[] books) {

		if (n == 0 || MAX == 0)
			return 0;

		if (bundleCosts[n - 1] > MAX)
			return budgetShopping(MAX, bundleQuantities, bundleCosts, n - 1, books);
		else {
			int weight1 = bundleCosts[n - 1]
					+ budgetShopping(MAX - bundleCosts[n - 1], bundleQuantities, bundleCosts, n - 1, books);
			int weight2 = budgetShopping(MAX, bundleQuantities, bundleCosts, n - 1, books);

			if (weight1 >= weight2) {
				books[0] += bundleQuantities[n - 1];
				return weight1;
			} else {
				return weight2;
			}
		}
	}

}
