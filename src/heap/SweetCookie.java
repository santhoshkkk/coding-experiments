package heap;

import java.util.Scanner;

/**
 * Heap is a binary tree with extra order and share properties. refere evernote
 * 
 * @author santhosh
 *
 */

public class SweetCookie {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		MinHeap heap = new MinHeap(10000);
		int N = s.nextInt();
		int minSweet = s.nextInt();
		for (int i = 0; i < N; i++) {
			int cookie = s.nextInt();
			heap.insert(cookie);
		}

		int ops = 0;

		while (heap.min() < minSweet) {
			int least = heap.removeMin();
			if(heap.isEmpty()){
				ops=-1;
				break;
			}
			int next = heap.removeMin();
			int newCookie = least + (next * 2);
			heap.insert(newCookie);
			ops++;
		}
		System.out.println(ops);
		s.close();
	}

}

class MinHeap {
	// elements from index 1 to N
	int[] nodes;
	int size;

	public MinHeap(int size) {
		nodes = new int[size + 1];
		size = 0;
	}

	boolean isEmpty() {
		return size <= 0;
	}

	void insert(int num) {
		nodes[++size] = num;
		reorderUp(size);
	}

	private void reorderUp(int index) {
		int parentIndex = getParentIndex(index);
		if (parentIndex > 0) {
			if (nodes[parentIndex] > nodes[index]) {
				swap(parentIndex, index);
				reorderUp(parentIndex);
			}
		}
	}

	private void swap(int index1, int index2) {
		int temp = nodes[index1];
		nodes[index1] = nodes[index2];
		nodes[index2] = temp;
	}

	int min() {
		if (!isEmpty()) {
			return nodes[1];
		} else {
			return Integer.MIN_VALUE;
		}
	}

	int removeMin() {
		int val = Integer.MIN_VALUE;
		if (!isEmpty()) {
			val = nodes[1];
		}
		swap(1, size--);
		if (!isEmpty()) {
			reOrderDown(1);
		}

		return val;
	}

	private void reOrderDown(int index) {
		int leftIndex = 2 * index;
		int rightIndex = leftIndex + 1;
		if (leftIndex > size && rightIndex > size) {
			return;
		} else if (rightIndex > size) {
			// last node at depth -1
			if (nodes[leftIndex] < nodes[index]) {
				swap(index, leftIndex);
				// No need to go further down since this will the last Node
			}
		} else {
			// Both left and right exists
			if (nodes[leftIndex] <= nodes[rightIndex]) {
				if (nodes[leftIndex] < nodes[index]) {
					swap(index, leftIndex);
					reOrderDown(leftIndex);
				}
			} else {
				if (nodes[rightIndex] < nodes[index]) {
					swap(index, rightIndex);
					reOrderDown(rightIndex);
				}
			}
		}
	}

	void removeAny(int num) {
		if (!isEmpty()) {
			int numIndex = findIndex(num, 1);
			if (0 != numIndex) {
				nodes[numIndex] = nodes[size--];
				reOrderDown(numIndex);
			}
		}
	}

	private int findIndex(int num, int index) {
		if (index > size) {
			return 0;
		}
		if (nodes[index] > num) {
			return 0;
		}
		if (nodes[index] == num) {
			return index;
		}

		int leftIndex = 2 * index;
		int rightIndex = leftIndex + 1;
		int leftTrav = findIndex(num, leftIndex);
		if (0 == leftTrav) {
			return findIndex(num, rightIndex);
		} else {
			return leftTrav;
		}
	}

	private int getParentIndex(int index) {
		return (int) Math.floor(index / 2);
	}

}
