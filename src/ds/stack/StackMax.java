package ds.stack;

import java.util.Scanner;

public class StackMax {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		Stack2 stack = new Stack2();
		for (int i = 0; i < N; i++) {
			int query = s.nextInt();
			switch (query) {
			case 1:
				int val = s.nextInt();
				stack.push(val);
				break;
			case 2:
				if (!stack.isEmpty()) {
					stack.pop();
				}
				break;
			case 3:
				if (!stack.isEmpty()) {
					System.out.println(stack.top());
				}
				break;
			default:
				break;
			}
		}
		s.close();
	}
}

class Stack2 {
	int[] data = new int[100000];
	int top = -1;

	boolean isEmpty() {
		return top == -1;
	}

	int top() {
		return data[top];
	}

	int pop() {
		return data[top--];
	}

	void push(int newdata) {
		data[++top] = newdata;
	}

}