package ds.stack;

import java.util.Scanner;

public class StackBracket {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		CustomStack stack1 = new CustomStack();
		for (int h1_i = 0; h1_i < n1; h1_i++) {
			stack1.push(in.nextInt());
		}

		CustomStack stack2 = new CustomStack();
		for (int h2_i = 0; h2_i < n2; h2_i++) {
			stack2.push(in.nextInt());
		}

		CustomStack stack3 = new CustomStack();
		for (int h3_i = 0; h3_i < n3; h3_i++) {
			stack3.push(in.nextInt());
		}

		while (!stack1.isEmpty() && !stack2.isEmpty() && !stack3.isEmpty()) {
			int stack1Height = stack1.height;
			int stack2Height = stack2.height;
			int stack3Height = stack3.height;
			System.out.println("stack1Height: " + stack1Height + "stack2Height: " + stack2Height + "stack3Height: "
					+ stack3Height);
			if (stack1Height == stack2Height && stack2Height == stack3Height) {
				System.out.println(stack1Height);
				return;
			}
			if (stack1Height != stack2Height) {
				if (stack1Height > stack2Height) {
					stack1.pop();
					System.out.println("stack1Height > stack2Height");
				} else {
					stack2.pop();
					System.out.println("stack1Height < stack2Height");
				}
			} else {
				if (stack2Height > stack3Height) {
					System.out.println("stack2Height > stack3Height");
					stack1.pop();
					stack2.pop();
				} else {
					System.out.println("stack2Height < stack3Height");
					stack3.pop();
				}
			}
		}
		System.out.println(0);
		in.close();
	}

}

class Node {
	int data;
	int height;
}

class CustomStack {
	int[] nodes = new int[100000];
	int height = 0;
	int top = 0;
	int bottom = -1;

	void push(int data) {
		height = height + data;
		nodes[++bottom] = data;
	}

	boolean isEmpty() {
		return top - 1 == bottom;
	}

	int top() {
		return nodes[top];
	}

	int pop() {
		int removedVal = nodes[top];
		height = height - removedVal;
		top++;
		return removedVal;
	}
}
