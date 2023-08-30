package br.ufpb.dcx.estruturadedados;

public interface Stack<Item> {

    int size();

    boolean isEmpty();

    Item peek() throws EmptyStackException;

    void push(Item item);

    Item pop() throws EmptyStackException;

    void resize(int newSize);

}
