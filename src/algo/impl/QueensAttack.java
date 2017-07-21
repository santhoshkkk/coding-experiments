package algo.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//Icomplete solution there are failure cases
public class QueensAttack {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int rQ = in.nextInt();
		int cQ = in.nextInt();
		ChessBoard board = new ChessBoard(n);
		for (int a0 = 0; a0 < k; a0++) {
			int rObs = in.nextInt();
			int cObs = in.nextInt();
			// your code goes here
			board.addCoin(--rObs, --cObs);
		}
		board.optimize();
		int squares = board.findMovableSquares(--rQ, --cQ);
		System.out.println(squares);
		in.close();
	}
}

class ChessBoard {
	int size;
	List<Integer>[] rowCoins;
	List<Integer>[] colCoins;
	Set<String> coins;

	public ChessBoard(int n) {
		size = n;
		rowCoins = new List[n];
		colCoins = new List[n];
		coins = new HashSet<>();
	}

	public int findMovableSquares(int rQ, int cQ) {
		int totalMovable = 0;
		totalMovable += find9OClockMovableSquares(rQ, cQ);
		totalMovable += find10OClockMovableSquares(rQ, cQ);
		totalMovable += find12OClockMovableSquares(rQ, cQ);
		totalMovable += find2OClockMovableSquares(rQ, cQ);
		totalMovable += find3OClockMovableSquares(rQ, cQ);
		totalMovable += find5OClockMovableSquares(rQ, cQ);
		totalMovable += find6OClockMovableSquares(rQ, cQ);
		totalMovable += find7OClockMovableSquares(rQ, cQ);
		return totalMovable;
	}

	private int find7OClockMovableSquares(int rQ, int cQ) {
		int count = 0;
		while (++rQ < size && --cQ >= 0 && !coins.contains(getKey(rQ, cQ))) {
			count++;
		}
		return count;
	}

	private int find6OClockMovableSquares(int rQ, int cQ) {
		int minBlockR = findMinRGreaterThan(rQ, cQ);
		if (-1 == minBlockR) {
			return (size - 1) - rQ;
		} else {
			return rQ - minBlockR;
		}
	}

	private int find5OClockMovableSquares(int rQ, int cQ) {
		int count = 0;
		while (++rQ < size && ++cQ < size && !coins.contains(getKey(rQ, cQ))) {
			count++;
		}
		return count;
	}

	private int find3OClockMovableSquares(int rQ, int cQ) {
		int minBlockC = findMinCGreaterThan(rQ, cQ);
		if (-1 == minBlockC) {
			return (size - 1) - cQ;
		} else {
			return minBlockC - cQ;
		}
	}

	private int find2OClockMovableSquares(int rQ, int cQ) {
		int count = 0;
		while (--rQ >= 0 && ++cQ < size && !coins.contains(getKey(rQ, cQ))) {
			count++;
		}
		return count;
	}

	private int find12OClockMovableSquares(int rQ, int cQ) {
		int maxBlockR = findMaxBlockRLessThan(rQ, cQ);
		if (-1 == maxBlockR) {
			return rQ;
		} else {
			return (rQ - maxBlockR) - 1;
		}
	}

	private int find10OClockMovableSquares(int rQ, int cQ) {
		int count = 0;
		while (--rQ >= 0 && --cQ >= 0 && !coins.contains(getKey(rQ, cQ))) {
			count++;
		}
		return count;
	}

	private int find9OClockMovableSquares(int rQ, int cQ) {
		int maxBlockC = findMaxCLessThan(rQ, cQ);
		if (-1 == maxBlockC) {
			return cQ;
		} else {
			return (cQ - maxBlockC) - 1;
		}
	}

	private int findMinRGreaterThan(int r, int c) {
		List<Integer> rowBlocks = colCoins[c];
		int minR = -1;
		if (null != rowBlocks) {
			for (int i = 0; i < rowBlocks.size(); i++) {
				if (rowBlocks.get(i) > r) {
					minR = rowBlocks.get(i);
					break;
				}
			}
		}
		return minR;
	}

	private int findMaxCLessThan(int r, int c) {
		List<Integer> colBlocks = rowCoins[r];
		int maxC = -1;
		if (null != colBlocks) {
			for (int i = colBlocks.size() - 1; i >= 0; i--) {
				if (colBlocks.get(i) < c) {
					maxC = colBlocks.get(i);
					break;
				}
			}
		}
		return maxC;
	}

	private int findMinCGreaterThan(int r, int c) {
		int minC = -1;
		List<Integer> colBlocks = rowCoins[r];
		if (null != colBlocks) {
			for (int i = 0; i < colBlocks.size(); i++) {
				if (colBlocks.get(i) > c) {
					minC = colBlocks.get(i);
					break;
				}
			}
		}
		return minC;
	}

	private int findMaxBlockRLessThan(int r, int c) {
		int maxR = -1;
		List<Integer> rowBlocks = colCoins[c];
		if (null != rowBlocks) {
			for (int i = rowBlocks.size() - 1; i >= 0; i--) {
				if (rowBlocks.get(i) < r) {
					maxR = rowBlocks.get(i);
					break;
				}
			}
		}
		return maxR;
	}

	public void addCoin(int r, int c) {
		List<Integer> rowCoinsEntry = rowCoins[r];
		if (null == rowCoinsEntry) {
			rowCoinsEntry = new ArrayList<>(size / 3);
			rowCoins[r] = rowCoinsEntry;
		}
		rowCoinsEntry.add(c);

		List<Integer> colCoinsEntry = colCoins[c];
		if (null == colCoinsEntry) {
			colCoinsEntry = new ArrayList<>(size / 3);
			colCoins[c] = colCoinsEntry;
		}
		colCoinsEntry.add(r);

		coins.add(getKey(r, c));
	}

	private String getKey(int r, int c) {
		return new StringBuffer().append(r).append("-").append(c).toString();
	}

	public void optimize() {
		for (int i = 0; i < size; i++) {
			if (null != rowCoins[i]) {
				Collections.sort(rowCoins[i]);
			}
			if (null != colCoins[i]) {
				Collections.sort(colCoins[i]);
			}
		}

	}
}
