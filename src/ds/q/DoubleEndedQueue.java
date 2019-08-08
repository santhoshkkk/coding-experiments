package ds.q;

public class DoubleEndedQueue {
    private int capacity;
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public DoubleEndedQueue(int inCapacity) {
        this.capacity = inCapacity;
        this.data = new int[capacity];
        front = 0;
        rear = capacity - 1;
        size = 0;
    }

    public static void main(String[] args) {
        DoubleEndedQueue doubleEndedQueue = new DoubleEndedQueue(5);
        System.out.println("deleteFront " + doubleEndedQueue.deleteFront());
        System.out.println("deleteRear " + doubleEndedQueue.deleteRear());
        doubleEndedQueue.insertFront(10);
        System.out.println("front " + doubleEndedQueue.front());
        doubleEndedQueue.insertFront(11);
        System.out.println("front " + doubleEndedQueue.front());
        doubleEndedQueue.insertRear(12);
        System.out.println("rear " + doubleEndedQueue.rear());
        System.out.println("deleteFront " + doubleEndedQueue.deleteFront());
        System.out.println("deleteRear " + doubleEndedQueue.deleteRear());
        System.out.println("front " + doubleEndedQueue.front());
        System.out.println("rear " + doubleEndedQueue.rear());
        System.out.println("deleteFront " + doubleEndedQueue.deleteFront());
        System.out.println("deleteRear " + doubleEndedQueue.deleteFront());
        System.out.println("deleteFront " + doubleEndedQueue.deleteFront());
        System.out.println("deleteRear " + doubleEndedQueue.deleteFront());
    }

    public void insertFront(int value) {
        if (isFull()) {
            System.out.print("Queue is full");
        } else {
            front = getPreviousIndex(front);
            data[front] = value;
            size++;
        }
    }

    public void insertRear(int value) {
        if (isFull()) {
            System.out.print("Queue is full");
        } else {
            rear = getNextIndex(rear);
            data[rear] = value;
            size++;
        }

    }

    public int deleteFront() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int value = data[front];
        front = getNextIndex(front);
        size--;
        return value;
    }

    public int deleteRear() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int value = data[rear];
        rear = getPreviousIndex(rear);
        size--;
        return value;
    }

    public int front() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return data[front];
    }

    public int rear() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return data[rear];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private int getNextIndex(int index) {
        return (index + 1) % capacity;
    }

    private int getPreviousIndex(int index) {
        return index != 0 ? index - 1 : capacity - 1;
    }
}

