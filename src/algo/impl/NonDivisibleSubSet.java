package algo.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NonDivisibleSubSet {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();

		Map<Integer, Integer> remindersCount = new HashMap<>();
		Map<Integer, Integer> reminderPairs = new HashMap<>();
		for (int i = 1; i <= k / 2; i++) {
			reminderPairs.put(i, k - i);
		}

		for (int i = 0; i < n; i++) {
			int reminder = s.nextInt() % k;
			Integer count = remindersCount.get(reminder);
			if (null == count) {
				count = 0;
			}
			remindersCount.put(reminder, ++count);
		}

		int totalCount = 0;
		Set<Integer> considered = new HashSet<Integer>();
		for (Integer reminder : remindersCount.keySet()) {
			if (0 == reminder || (k % 2 == 0 && k / 2 == reminder)) {
				totalCount++;
			} else {
				if (!considered.contains(reminder)) {
					int count = remindersCount.get(reminder);
					Integer pair = reminderPairs.get(reminder);
					if (null == pair) {
						totalCount += count;
					} else {
						Integer pairCount = remindersCount.get(pair);
						if (null == pairCount) {
							pairCount = 0;
						}
						if (count > pairCount) {
							totalCount += count;
						} else {
							totalCount += pairCount;
						}
						considered.add(pair);
					}
					considered.add(reminder);
				}
			}
		}
		System.out.println(totalCount);
		s.close();
	}

}
