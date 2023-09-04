package br.ufpb.dcx.datastructures.stack;

/**
 * Interface to a stack: a type of data structure that
 * follows the last-in, first-out (LIFO) principle
 * @param <Item> an object of any type
 */
public interface Stack<Item> {

    /**
     * Returns the maximum capacity of the array
     * @return the maximum capacity of the array
     */
    int capacity();

    /**
     * Returns the amount of elements in the stack
     * @return the amount of elements in the stack
     */
    int size();

    /**
     * Checks if the stack is empty or not
     * @return true if it's empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the item on top of the stack
     * @return the item on top of the stack
     * @throws EmptyStackException if it's empty
     */
    Item peek() throws EmptyStackException;

    /**
     * Adds an item on top of the stack<br>
     * If the variable-length stack is full, the array will be resized to
     * twice its original capacity
     * @param item the item to be added
     * @throws FullStackException if it's full
     */
    void push(Item item) throws FullStackException;

    /**
     * Removes the item on top of the stack<br>
     * If size() is equal to a quarter of the array's original capacity,
     * it will be resized to half its original capacity
     * @return the item that was popped
     * @throws EmptyStackException if it's empty
     */
    Item pop() throws EmptyStackException;

    /**
     * Reverses the stack
     * @throws EmptyStackException if it's empty
     */
    void reverse() throws EmptyStackException;

}