package br.ufpb.dcx.datastructures.queue;

/**
 * Class that implements a fixed-length queue using arrays
 * @param <Item> an object of any type
 */
public class FixedArrayQueue<Item> implements Queue<Item> {

    private final Item[] q;
    private final int capacity;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public FixedArrayQueue(int cap) {
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
    public void enqueue(Item item) throws FullQueueException {
        if (size() == capacity - 1) throw new FullQueueException("Queue is full.");
        q[tail] = item;
        tail = (tail + 1) % capacity;
    }

    @Override
    public Item dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException("Queue is empty.");
        Item item = q[head];
        q[head] = null;
        head = (head + 1) % capacity;
        return item;
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