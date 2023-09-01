package br.ufpb.dcx.estruturadedados;

/**
 * Stack interface: a collection of objects that follows
 * the LIFO (Last in, first out) philosophy
 * @param <Item>
 */
public interface Stack<Item> {

    /**
     * The number of elements in the stack
     * @return the number of elements in the stack
     */
    int size();

    /**
     * Check if the stack is empty
     * @return true if the stack is empty, otherwise will return false
     */
    boolean isEmpty();

    /**
     * The item on top of the stack
     * @return the item on top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    Item peek() throws EmptyStackException;

    /**
     * Add an item on top of the stack<br>
     * If the stack is full, the array will be resized to
     * twice its original capacity
     * @param item item to be added
     */
    void push(Item item);

    /**
     * Remove the item on top of the stack<br>
     * If the stack size equals to a quarter of the array capacity, the array
     * will be resized to half its original capacity
     * @return the removed item
     * @throws EmptyStackException if the stack is empty
     */
    Item pop() throws EmptyStackException;

    /**
     * Resize the array
     * @param newSize the new size of the array
     */
    void resize(int newSize);

}
