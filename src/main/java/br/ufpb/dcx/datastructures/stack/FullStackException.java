package br.ufpb.dcx.datastructures.stack;

/**
 * Exception thrown if the stack is full
 */
public class FullStackException extends RuntimeException {

    public FullStackException(String err) {
        super(err);
    }

}