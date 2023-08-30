package br.ufpb.dcx.estruturadedados;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayStack {

    ArrayStack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new ArrayStack<>(3);
    }

    @Test
    public void testPushAndPop() throws EmptyStackException {
        assertEquals(0, stack.size());

        stack.push(6);
        assertEquals(6, stack.peek());
        assertEquals(1, stack.size());

        stack.push(9);
        assertEquals(9, stack.peek());
        assertEquals(2, stack.size());

        assertEquals(9, stack.pop());
        assertNotEquals(9, stack.pop());

        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void testResize() throws EmptyStackException {
        for (int i = 1; i < 7; i++) stack.push(i);
        assertEquals(6, stack.getArrayLength());

        stack.push(7);
        stack.push(8);
        stack.push(9);

        for (int i = 0; i < 7; i++) stack.pop();
        assertEquals(6, stack.getArrayLength());
    }

    @Test
    public void testToString() throws EmptyStackException {
        for (int i = 0; i < 10; i++) stack.push(i);
        assertEquals("[0 1 2 3 4 5 6 7 8 9]", stack.toString());
        stack.pop();
        assertEquals("[0 1 2 3 4 5 6 7 8]", stack.toString());
        stack.push(17);
        assertEquals("[0 1 2 3 4 5 6 7 8 17]", stack.toString());
    }

}
