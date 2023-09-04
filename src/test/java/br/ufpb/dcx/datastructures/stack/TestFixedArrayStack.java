package br.ufpb.dcx.datastructures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFixedArrayStack {

    Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new FixedArrayStack<>(2);
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
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());

        stack.push(4);
        assertEquals(4, stack.pop());
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
    public void testPushFull() {
        stack.push(1);
        stack.push(2);
        assertThrows(FullStackException.class, () -> stack.push(3));
        assertEquals(2, stack.size());
    }

    @Test
    public void testToStringEmpty() {
        assertEquals("[]", stack.toString());
    }

    @Test
    public void testToStringNonEmptyStack() {
        stack.push(1);
        stack.push(2);
        assertEquals("[1 2]", stack.toString());
    }

    @Test
    public void testToStringAfterPop() {
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertEquals("[1]", stack.toString());
    }

    @Test
    public void testToStringAfterFull() {
        stack.push(1);
        stack.push(2);
        assertThrows(FullStackException.class, () -> stack.push(3));
        assertEquals("[1 2]", stack.toString());

        stack.pop();
        assertEquals("[1]", stack.toString());
    }

    @Test
    public void testReverse() {
        stack.push(1);
        stack.push(2);
        stack.reverse();
        assertEquals("[2 1]", stack.toString());
    }

}