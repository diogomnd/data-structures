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
    public void testPushAndPop() {
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
    public void testResize() {
        for (int i = 1; i < 7; i++) stack.push(i);
        assertEquals(6, stack.capacity);

        stack.push(7);
        stack.push(8);
        stack.push(9);

        for (int i = 0; i < 7; i++) stack.pop();
        assertEquals(6, stack.capacity);
    }

    @Test
    public void testToString() {
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
        assertEquals("[]", stack.toString());

        stack.push(5);
        assertEquals("[5]", stack.toString());
        stack.push(3);
        assertEquals("[5 3]", stack.toString());

        assertEquals(3, stack.pop());
        assertEquals("[5]", stack.toString());

        stack.push(7);
        assertEquals("[5 7]", stack.toString());

        assertEquals(7, stack.pop());
        assertEquals("[5]", stack.toString());

        assertEquals(5, stack.peek());
        assertEquals("[5]", stack.toString());

        assertEquals(5, stack.pop());
        assertEquals("[]", stack.toString());

        assertThrows(EmptyStackException.class, () -> stack.pop());
        assertEquals("[]", stack.toString());

        assertTrue(stack.isEmpty());
        assertEquals("[]", stack.toString());

        stack.push(9);
        assertEquals("[9]", stack.toString());

        stack.push(7);
        assertEquals("[9 7]", stack.toString());

        stack.push(3);
        assertEquals("[9 7 3]", stack.toString());

        stack.push(5);
        assertEquals("[9 7 3 5]", stack.toString());

        assertEquals(4, stack.size());
        assertEquals("[9 7 3 5]", stack.toString());

        assertEquals(5, stack.pop());
        assertEquals("[9 7 3]", stack.toString());

        stack.push(8);
        assertEquals("[9 7 3 8]", stack.toString());

        assertEquals(8, stack.pop());
        assertEquals("[9 7 3]", stack.toString());

        assertEquals(3, stack.pop());
        assertEquals("[9 7]", stack.toString());
    }

}
