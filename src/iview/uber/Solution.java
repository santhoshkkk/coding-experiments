package iview.uber;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int emp = s.nextInt();
		int[] scores = new int[emp];
		for (int i = 0; i < emp; i++) {
			scores[i] = s.nextInt();
		}
		int team = s.nextInt();
		int m = s.nextInt();
		System.out.println(teamFormation(scores, team, m));

		s.close();
	}

	static long teamFormation(int[] score, int team, int m) {

		long teamScore = 0l;

		if (team >= score.length) {
			for (int scr : score) {
				teamScore += scr;
			}
			return teamScore;
		}

		// TODO Move to method
		TreeSet<Integer> firstTree = new TreeSet<Integer>(new IntegerReverseComapartor());
		TreeSet<Integer> lastTree = new TreeSet<Integer>(new IntegerReverseComapartor());

		int i = 0;
		for (; i < m; i++) {
			firstTree.add(score[i]);
		}

		int forwardIndex = i;
		int j = score.length - 1;
		for (; j > (score.length - m) - 1 && j >= forwardIndex; j--) {
			lastTree.add(score[j]);
		}
		int backwardIndex = j;

		for (int k = 0; k < team; k++) {
			if (!firstTree.isEmpty() && !lastTree.isEmpty()) {
				int firstMax = firstTree.iterator().next();
				int lastMax = lastTree.iterator().next();
				if (firstMax > lastMax) {
					firstTree.remove(firstMax);
					teamScore += firstMax;
					if (forwardIndex <= backwardIndex) {
						firstTree.add(score[forwardIndex++]);
					}
				} else {
					lastTree.remove(lastMax);
					teamScore += lastMax;
					if (forwardIndex <= backwardIndex) {
						lastTree.add(score[backwardIndex--]);
					}
				}
			} else if (!lastTree.isEmpty()) {
				int max = lastTree.iterator().next();
				lastTree.remove(max);
				teamScore += max;
				if (forwardIndex <= backwardIndex) {
					lastTree.add(score[backwardIndex--]);
				}

			} else if (!firstTree.isEmpty()) {
				int max = firstTree.iterator().next();
				firstTree.remove(max);
				teamScore += max;
				if (forwardIndex <= backwardIndex) {
					firstTree.add(score[forwardIndex++]);
				}
			} else {
				break;
			}

		}

		return teamScore;

	}

	static class IntegerReverseComapartor implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}

	}

}
