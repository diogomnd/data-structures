package br.ufpb.dcx.datastructures.queue;

/**
 * Exception thrown if the queue is empty
 */
public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException(String err) {
        super(err);
    }

}