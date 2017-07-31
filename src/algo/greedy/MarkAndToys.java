package algo.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MarkAndToys {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt(), k = stdin.nextInt();

		PriorityQueue<Integer> q = new PriorityQueue<>(new IntegerReverseComparator());
		int price;
		int sum = 0;
		int tempSum = 0;
		for (int i = 0; i < n; i++) {
			price = stdin.nextInt();
			tempSum = sum + price;
			if (tempSum <= k) {
				q.add(price);
				sum = tempSum;
			} else {
				if (!q.isEmpty() && q.peek() > price) {
					sum = sum - q.poll();
					q.add(price);
					sum = sum + price;
				}
			}
		}

		System.out.println(sum);
		System.out.println(q.size());

		stdin.close();

	}

}

class IntegerReverseComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}

}
