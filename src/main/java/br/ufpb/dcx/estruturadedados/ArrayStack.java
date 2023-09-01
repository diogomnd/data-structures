package br.ufpb.dcx.estruturadedados;

public class ArrayStack<Item> implements Stack<Item> {

    protected int capacity;
    private Item[] array;
    private int top;

    @SuppressWarnings("unchecked")
    public ArrayStack(int cap) {
        top = -1;
        capacity = cap;
        array = (Item[]) new Object[capacity];
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
        return array[top];
    }

    @Override
    public void push(Item item) {
        if (size() == capacity) resize(2 * capacity);
        array[++top] = item;
    }

    @Override
    public Item pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is empty.");
        Item item = array[top--];
        if (size() > 0 && size() == capacity / 4) resize(capacity / 2);
        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void resize(int newSize) {
        capacity = newSize;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size(); i++)
            temp[i] = array[i];
        array = temp;
    }

    @Override
    public String toString() {
        StringBuilder stackString = new StringBuilder();
        stackString.append("[");
        for (int i = 0; i < size(); i++) {
            if (i == size() - 1)
                stackString.append(array[i]);
            else
                stackString.append(array[i]).append(" ");
        }
        stackString.append("]");
        return stackString.toString();
    }

}
