package br.ufpb.dcx.datastructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFixedArrayQueue {

    Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new FixedArrayQueue<>(2);
    }

    @Test
    public void testEnqueueAndDequeue() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());

        assertFalse(queue.isEmpty());
        assertEquals(1, queue.dequeue());
        assertEquals(1, queue.size());
    }

    @Test
    public void testMultipleEnqueueAndDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(0, queue.size());

        queue.enqueue(4);
        assertEquals(4, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testFront() {
        assertThrows(EmptyQueueException.class, () -> queue.front());
        queue.enqueue(1);
        assertEquals(1, queue.front());
    }

    @Test
    public void testDequeueEmpty() {
        assertThrows(EmptyQueueException.class, () -> queue.dequeue());
    }

    @Test
    public void testEnqueueFull() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertThrows(FullQueueException.class, () -> queue.enqueue(3));
        assertEquals(2, queue.size());
    }

    @Test
    public void testToStringEmpty() {
        assertEquals("[]", queue.toString());
    }

    @Test
    public void testToStringNonEmptyQueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals("[1 2]", queue.toString());
    }

    @Test
    public void testToStringAfterDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        assertEquals("[2]", queue.toString());
    }

    @Test
    public void testToStringAfterFull() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertThrows(FullQueueException.class, () -> queue.enqueue(3));
        assertEquals("[1 2]", queue.toString());

        queue.dequeue();
        assertEquals("[2]", queue.toString());
    }

}