package br.ufpb.dcx.estruturadedados;

public class ArrayStack<Item> implements Stack<Item> {

    private Item[] array;
    private int top;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.top = -1;
        this.array = (Item[]) new Object[capacity];
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
        if (size() == array.length) resize(2 * array.length);
        top++;
        array[top] = item;
    }

    @Override
    public Item pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is empty.");
        if (size() > 0 && size() == array.length / 4)
            resize(array.length / 2);
        Item item = array[top];
        top--;
        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < size(); i++)
            temp[i] = array[i];
        array = temp;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < size(); i++)
            if (i == size() - 1)
                s.append(array[i]);
            else
                s.append(array[i]).append(" ");
        s.append("]");
        return s.toString();
    }

    public int getArrayLength() {
        return this.array.length;
    }

}
