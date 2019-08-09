package ds.q;

import java.util.Scanner;

public class LinkedPriorityQueue {
    private PriorityQueueLinkedListNode head;

    public static void main(String args[]) {
        LinkedPriorityQueue linkedPriorityQueue = new LinkedPriorityQueue();

        String menu = "1. enqueue followed by data and priority\n" +
                "2. dequeue\n" +
                "3. font\n" +
                "4. print queue\n" +
                "0. exit\n\n";

        System.out.println("Welcome to Priority Queue\n");
        System.out.println(menu);

        Scanner scanner = new Scanner(System.in);
        int command;

        do {
            command = scanner.nextInt();

            drive(linkedPriorityQueue, menu, scanner, command);
        } while (command != 0);
    }

    private static void drive(LinkedPriorityQueue linkedPriorityQueue, String menu, Scanner scanner, int command) {
        switch (command) {
            case 0:
                System.out.println("Bye");
                break;

            case 1:
                int data = scanner.nextInt();
                int priority = scanner.nextInt();
                linkedPriorityQueue.enqueue(data, priority);
                break;

            case 2:
                PriorityQueueLinkedListNode dequeue = linkedPriorityQueue.dequeue();
                System.out.println("dequeued: " + dequeue);
                break;

            case 3:
                PriorityQueueLinkedListNode front = linkedPriorityQueue.front();
                System.out.println("front: " + front);
                break;

            case 4:
                System.out.println(linkedPriorityQueue);
                break;

            default:
                System.out.println("Sorry I did not get that\n" + menu);

        }
    }

    public void enqueue(Object value, int priority) {

        PriorityQueueLinkedListNode newNode = new PriorityQueueLinkedListNode(value, priority);

        if (isEmpty() || this.head.getPriority() < priority) {
            newNode.setNext(head);
            this.head = newNode;
        } else {
            insertAfterHead(newNode);
        }

    }

    public PriorityQueueLinkedListNode dequeue() {
        if (!isEmpty()) {
            PriorityQueueLinkedListNode oldHead = head;
            head = head.getNext();
            return oldHead;
        } else {
            return null;
        }
    }

    public PriorityQueueLinkedListNode front() {
        return head;
    }

    private void insertAfterHead(PriorityQueueLinkedListNode newNode) {
        PriorityQueueLinkedListNode node = head;
        PriorityQueueLinkedListNode next;
        while (node.getNext() != null && node.getNext().getPriority() > newNode.getPriority()) {
            node = node.getNext();
        }
        newNode.setNext(node.getNext());
        node.setNext(newNode);
    }

    private boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        PriorityQueueLinkedListNode node = head;
        boolean first = true;
        while (node != null) {
            if (!first) {
                builder.append(",");
            } else {
                first = false;
            }

            builder.append(node.toString());
            node = node.getNext();
        }
        builder.append("}");
        return builder.toString();
    }
}

class PriorityQueueLinkedListNode {
    private Object data;
    private int priority;
    private PriorityQueueLinkedListNode next;

    public PriorityQueueLinkedListNode(Object data, int priority) {
        this.data = data;
        this.priority = priority;
    }

    public Object getData() {
        return data;
    }

    public PriorityQueueLinkedListNode getNext() {
        return next;
    }

    public void setNext(PriorityQueueLinkedListNode next) {
        this.next = next;
    }

    public int getPriority() {
        return priority;
    }

    public String toString() {
        return new StringBuilder("[").append(data).append("-").append(priority).append("]").toString();
    }
}


