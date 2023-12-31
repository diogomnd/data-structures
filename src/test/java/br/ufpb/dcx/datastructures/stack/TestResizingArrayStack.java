package br.ufpb.dcx.datastructures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestResizingArrayStack {

    Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new ResizingArrayStack<>(2);
    }

    @Test
    public void testPushAndPop() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());

        assertFalse(stack.isEmpty());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    public void testMultiplePushAndPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());

        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());

        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        assertThrows(EmptyStackException.class, () -> stack.peek());
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    @Test
    public void testPopEmpty() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void testResize() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());

        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());

        assertEquals(2, stack.capacity());
    }

    @Test
    public void testToStringEmpty() {
        assertEquals("[]", stack.toString());
    }

    @Test
    public void testToStringNonEmptyStack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("[1 2 3]", stack.toString());
    }

    @Test
    public void testToStringAfterPop() {
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertEquals("[1]", stack.toString());
    }

    @Test
    public void testToStringAfterResize() {
        for (int i = 1; i <= 5; i++)
            stack.push(i);
        assertEquals("[1 2 3 4 5]", stack.toString());

        for (int i = 1; i <= 3; i++)
            stack.pop();
        assertEquals("[1 2]", stack.toString());
    }

    @Test
    public void testReverse() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.reverse();
        assertEquals("[3 2 1]", stack.toString());
    }

}