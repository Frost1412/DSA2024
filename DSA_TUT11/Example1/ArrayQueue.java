/**
 * Class ArrayQueue implements an array-based queue data structure. Each element of the queue is an integer.
 * Please refer to Lecture 7 for the array-based queue ADT in detail. 
 * @author (nxthang) 
 * @version (1.0)
 */
package DSA_TUT11.Example1;
public class ArrayQueue
{
    private int[] items;
    private static final int maxSize=10000;
    private int front;
    private int rear;
    /**
     * Constructor for objects of class ArrayQueue.
     * This constructor creates an empty queue.
     */
    public ArrayQueue()
    {
    	items = new int[maxSize];
    	this.front = 0;
    	this.rear = -1;
    }

    /**
     * This operation returns true if the queue is empty, otherwise it returns false
     */    
    public boolean isEmpty()
    {
    	return front == (rear + 1) % maxSize;
    }
    
    /**
     * This operation returns true if the queue is full, otherwise it returns false
     */    
    public boolean isFull()
    {
    	return front == (rear + 2) % maxSize;
    }
    
    /**
     * This operation adds a newItem to the queue.
     */        
    public void enqueue(int newItem)
    {
    	if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % maxSize;
        items[rear] = newItem;
    }

    /**
     * This operation returns the item at the front position of the queue and deletes this item.
     */    
    public int dequeue()
    {
    	if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = items[front];
        front = (front + 1) % maxSize;
        return item;
    }
    
    /**
     * This operation returns an item at the front position of the queue. This item will not be deleted.
     */        
    public int peek()
    {
    	return items[front];
    }
}