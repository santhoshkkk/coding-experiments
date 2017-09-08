package ds.q;

import java.util.Scanner;

public class QStack {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int q = s.nextInt();

		MyQ qu = new MyQ(q);
		for (int i = 0; i < q; i++) {
			int c = s.nextInt();
			switch (c) {
			case 1:
				qu.enq(s.nextInt());
				break;
			case 2:
				qu.deq();
				break;
			case 3:
				System.out.println(qu.front());
				break;
			}
		}
		s.close();

	}
}

class MyQ {

	MyStack mn;
	MyStack bkp;

	MyQ(int n) {
		mn = new MyStack(n);
		bkp = new MyStack(n);
	}


	void enq(int data) {
		mn.push(data);
	}

	int deq() {
		if(bkp.empty()){
			while (!mn.empty()) {
				bkp.push(mn.pop());
			}
		}
		int data = -1;
		if(!bkp.empty()){
			data=bkp.pop();
		}
		return data;
	}

	int front() {
		if(bkp.empty()){
			while (!mn.empty()) {
				bkp.push(mn.pop());
			}
		}
		int data = -1;
		if(!bkp.empty()){
			data=bkp.peek();
		}
		return data;
	}
}

class MyStack {
	int[] data;
	int top = -1;

	MyStack(int size) {
		data = new int[size];
	}

	boolean empty() {
		return top == -1;
	}

	int peek() {
		return data[top];
	}

	int pop() {
		return data[top--];
	}

	void push(int newdata) {
		data[++top] = newdata;
	}
	
}
