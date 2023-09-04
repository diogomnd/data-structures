package br.ufpb.dcx.datastructures.queue;

/**
 * Interface to a queue: a type of data structure that
 * follows the first-in, first-out (FIFO) principle
 * @param <Item> an object of any type
 */
public interface Queue<Item> {

    /**
     * Returns the maximum capacity of the array
     * @return the maximum capacity of the array
     */
    int capacity();

    /**
     * Returns the amount of elements in the queue
     * @return the amount of elements in the queue
     */
    int size();

    /**
     * Checks if the queue is empty or not
     * @return true if it's empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the item at the head of the queue
     * @return the item at the head of the queue
     * @throws EmptyQueueException if the queue is empty
     */
    Item front() throws EmptyQueueException;

    /**
     * Queues the item at the tail of the queue<br>
     * If the variable-length queue is full, the array will be resized to
     * twice its original capacity
     * @param item the item to be enqueued
     * @throws FullQueueException if the queue is full
     */
    void enqueue(Item item) throws FullQueueException;

    /**
     * Dequeues the item at the head of the queue<br>
     * If size() is equal to a quarter of the array's original capacity,
     * it will be resized to half its original capacity
     * @return the item that was dequeued
     * @throws EmptyQueueException if the queue is empty
     */
    Item dequeue() throws EmptyQueueException;

}