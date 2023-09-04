package br.ufpb.dcx.datastructures.queue;

/**
 * Exception thrown if the queue is full
 */
public class FullQueueException extends RuntimeException {

    public FullQueueException(String err) {
        super(err);
    }

}
