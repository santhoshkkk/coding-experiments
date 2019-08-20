package ds.stack;

//TODO revisit
public class Stack<T extends Object> {
    private Object[] data;
    private int top = -1;

    public Stack(int size) {
        data = new Object[size];
    }

    public void push(T in) {
        if (!isFull()) {
            data[++top] = in;
        }
    }

    private boolean isFull() {
        return data.length - 1 == top;
    }

    public T pop() throws Exception {
        if (!isEmpty()) {
            return (T) data[top--];
        } else {
            throw new Exception("Stack is empty");
        }
    }

    private boolean isEmpty() {
        return -1 == top;
    }

    public T top() throws Exception {
        if (!isEmpty()) {
            return (T) data[top];
        } else {
            throw new Exception("Stack is empty");
        }
    }

}
