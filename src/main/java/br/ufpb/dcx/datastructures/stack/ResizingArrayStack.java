package br.ufpb.dcx.datastructures.stack;

public class ResizingArrayStack<Item> implements Stack<Item> {

    private Item[] s;
    private int capacity;
    private int top;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack(int cap) {
        capacity = cap;
        s = (Item[]) new Object[capacity];
        top = -1;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public Item peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is empty.");
        return s[top];
    }

    @Override
    public void push(Item item) {
        if (size() == capacity) resize(2 * capacity);
        s[++top] = item;
    }

    @Override
    public Item pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is empty.");
        Item item = s[top];
        s[top--] = null;
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
            temp[i] = s[i];
        s = temp;
        capacity = newCapacity;
    }

    @Override
    public void reverse() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is empty");
        Stack<Item> r = new ResizingArrayStack<>(capacity);
        int size = size();
        for (int i = 0; i < size; i++)
            r.push(s[i]);
        for (int i = 0; i < size; i++)
            s[i] = r.pop();
    }

    @Override
    public String toString() {
        StringBuilder stringStack = new StringBuilder();
        int size = size();
        stringStack.append("[");
        for (int i = 0; i < size; i++) {
            stringStack.append(s[i]);
            if (i < size - 1)
                stringStack.append(" ");
        }
        stringStack.append("]");
        return stringStack.toString();
    }

}