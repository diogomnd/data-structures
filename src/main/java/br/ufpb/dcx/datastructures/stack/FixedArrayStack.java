package br.ufpb.dcx.datastructures.stack;

public class FixedArrayStack<Item> implements Stack<Item> {

    private final Item[] s;
    private final int capacity;
    private int top;

    @SuppressWarnings("unchecked")
    public FixedArrayStack(int cap) {
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
    public void push(Item item) throws FullStackException{
        if (size() == capacity) throw new FullStackException("Stack is full.");
        s[++top] = item;
    }

    @Override
    public Item pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is empty.");
        Item item = s[top];
        s[top--] = null;
        return item;
    }

    @Override
    public void reverse() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is empty");
        Stack<Item> r = new FixedArrayStack<>(capacity);
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