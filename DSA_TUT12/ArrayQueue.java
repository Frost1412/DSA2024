package DSAall.DSA_TUT12;

public class ArrayQueue {
    private static final int maxSize = 1000;
    private GVertex[] items;
    private int front, rear;

    public ArrayQueue() {
        this.items = new GVertex[maxSize];
        this.front = 0;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return this.front == this.rear + 1;
    }

    public boolean isFull() {
        return this.rear == maxSize - 1;
    }

    public void enqueue(GVertex newIteam) {
        if (isFull()) {
            throw new IllegalStateException("Queue overflow");
        }

        rear = (rear + 1) % items.length;
        items[rear] = newIteam;
    }

    public GVertex dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }

        GVertex item = items[front];
        front = (front + 1) % items.length;
        return item;
    }

    public GVertex peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }

        return items[front];
    }
}
