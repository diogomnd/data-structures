package br.ufpb.dcx.datastructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestResizingArrayQueue {

    Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new ResizingArrayQueue<>(2);
    }

    @Test
    public void testEnqueueAndDequeue() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
        assertEquals(1, queue.front());

        assertFalse(queue.isEmpty());
        assertEquals(1, queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals(2, queue.front());
    }

    @Test
    public void testMultipleEnqueueAndDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.size());

        queue.enqueue(4);
        assertEquals(3, queue.dequeue());
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
    public void testResize() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());

        assertEquals(1, queue.size());
        assertEquals(3, queue.front());

        queue.enqueue(4);

        assertTrue(queue.capacity() > 2);
    }

    @Test
    public void testToStringEmpty() {
        assertEquals("[]", queue.toString());
    }

    @Test
    public void testToStringNonEmptyQueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals("[1 2 3]", queue.toString());
    }

    @Test
    public void testToStringAfterDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        assertEquals("[2]", queue.toString());
    }

    @Test
    public void testToStringAfterResize() {
        for (int i = 1; i <= 5; i++)
            queue.enqueue(i);
        assertEquals("[1 2 3 4 5]", queue.toString());

        for (int i = 1; i <= 3; i++)
            queue.dequeue();
        assertEquals("[4 5]", queue.toString());
    }

}