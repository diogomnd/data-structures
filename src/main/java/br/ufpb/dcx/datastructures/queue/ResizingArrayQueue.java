package br.ufpb.dcx.datastructures.queue;

/**
 * Class that implements a variable length queue using arrays
 * @param <Item> an object of any type
 */
public class ResizingArrayQueue<Item> implements Queue<Item> {

    private Item[] q;
    private int capacity;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public ResizingArrayQueue(int cap) {
        capacity = cap + 1;  // Add 1 for an extra space between the head and the tail
        q = (Item[]) new Object[capacity];
        head = tail = 0;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int size() {
        return (capacity - head + tail) % capacity;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public Item front() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException("Queue is empty.");
        return q[head];
    }

    @Override
    public void enqueue(Item item) {
        if (size() == capacity - 1) resize(2 * capacity);
        q[tail] = item;
        tail = (tail + 1) % capacity;
    }

    @Override
    public Item dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException("Queue is empty.");
        Item item = q[head];
        q[head] = null;
        head = (head + 1) % capacity;
        if (size() <= capacity / 4) resize(capacity / 2);
        return item;
    }

    /**
     * Resizes the array
     * @param newCapacity the new size that'll be used for resizing
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        Item[] temp = (Item[]) new Object[newCapacity];
        int size = size();
        for (int i = 0; i < size; i++)
            temp[i] = q[(head + i) % capacity];
        q = temp;
        head = 0;
        tail = size;  // The next empty position
        capacity = newCapacity;
    }

    @Override
    public String toString() {
        StringBuilder stringQueue = new StringBuilder();
        int size = size();
        stringQueue.append("[");
        for (int i = 0; i < size; i++) {
            stringQueue.append(q[(head + i) % capacity]);
            if (i < size - 1)
                stringQueue.append(" ");
        }
        stringQueue.append("]");
        return stringQueue.toString();
    }

}