package algo.dynamic;

import java.util.Scanner;

public class KnapsackDynamic {

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

	private static int knapSack(int numOfItems, int maxWeight, int[] weights, int[] values) {
		// This array holds solution for the knapsack problem for any given
		// number and maxWeight value upto the maxWeight given
		int[][] allValues = new int[numOfItems + 1][maxWeight + 1];

		// Problem is solved by consturcting the solution bottom up.i.e starting
		// from 0 items 0 maxWeight to n items and given maxWeight

		for (int items = 0; items <= numOfItems; items++) {
			for (int weight = 0; weight <= maxWeight; weight++) {
				if (items == 0 || weight == 0) {
					allValues[items][weight] = 0;
				} else if (weights[items - 1] > weight) {
					// current items weight is greater than weight under
					// consideration
					allValues[items][weight] = allValues[items - 1][weight];
				} else {// weights[items-1]<=weight
					// current items weight is less than weight under
					// consideration
					allValues[items][weight] = max(
							values[items - 1] + allValues[items - 1][weight - weights[items - 1]],
							allValues[items - 1][weight]);
					;
				}
			}
		}

		return allValues[numOfItems ][maxWeight ];
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
