package br.ufpb.dcx.datastructures.stack;

public class ResizingArrayStack<Item> implements Stack<Item> {

    private int capacity;
    private Item[] s;
    private int top;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack(int cap) {
        top = -1;
        capacity = cap;
        s = (Item[]) new Object[capacity];
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
        if (size() == capacity / 4) resize(capacity / 2);
        return item;
    }

    /**
     * Resizes the array
     * @param newSize the new size that'll be used for resizing
     */
    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < size(); i++)
            temp[i] = s[i];
        capacity = newSize;
        s = temp;
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
        stringStack.append("[");
        int size = size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1)
                stringStack.append(s[i]);
            else
                stringStack.append(s[i]).append(" ");
        }
        stringStack.append("]");
        return stringStack.toString();
    }

}