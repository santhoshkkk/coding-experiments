package algo.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) {
		PriorityQueue<Integer> p = new PriorityQueue<>(10, new IntReverseComparator());
		for (int i = 0; i < 10; i++) {
			p.add(i);
		}

		while (!p.isEmpty()) {
			System.out.println(p.poll());
		}
	}

}

class IntReverseComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}

}
