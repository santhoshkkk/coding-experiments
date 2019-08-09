package ds.q;

import java.util.Scanner;

public class Queue {
    private Object[] data;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        data = new Object[capacity];
        rear = capacity - 1;
        front = 0;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        String menu = "1. enqueue followed by data and priority\n" +
                "2. dequeue\n" +
                "3. font\n" +
                "4. print queue\n" +
                "5. reverse\n" +
                "0. exit\n\n";

        System.out.println("Welcome to Priority Queue\n");
        System.out.println(menu);

        Scanner scanner = new Scanner(System.in);
        int command;

        do {
            command = scanner.nextInt();

            drive(queue, menu, scanner, command);
        } while (command != 0);
    }

    private static void drive(Queue queue, String menu, Scanner scanner, int command) {
        switch (command) {
            case 0:
                break;
            case 1:
                queue.enqueue(scanner.nextInt());
                break;
            case 2:
                System.out.println("dequeued: " + queue.dequeue());
                break;
            case 3:
                System.out.println("front: " + queue.front());
                break;
            case 4:
                System.out.println(queue.toString());
                break;
            case 5:
                queue.reverse(queue);
                break;
            default:
                System.out.println("Sorry I did not get that : \n" + menu);
                break;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public void enqueue(Object value) {
        if (isFull()) {
            System.out.print("Queue is full");
        } else {
            rear = nextIndex(rear);
            data[rear] = value;
            size++;
        }
    }

    public Object dequeue() {
        Object value = null;
        if (!isEmpty()) {
            value = data[front];
            front = nextIndex(front);
            size--;
        }
        return value;
    }

    public Object front() {
        return data[front];
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        boolean first = true;
        int index = front;
        for (int i = 1; i <= size; i++) {
            if (first) {
                first = false;
            } else {
                builder.append(",");
            }
            builder.append(data[index]);
            index = nextIndex(index);
        }
        builder.append("}");
        return builder.toString();
    }

    public int nextIndex(int index) {
        return (index + 1) % data.length;
    }

    public void reverse(Queue original) {
        if(original.isEmpty()){
            return;
        }
        Object value = original.dequeue();
        reverse(original);
        original.enqueue(value);
    }

}
