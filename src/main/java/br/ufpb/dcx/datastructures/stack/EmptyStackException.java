package br.ufpb.dcx.datastructures.stack;

/**
 * Exception that will be thrown if pop() or top()
 * are executed on an empty stack
 */
public class EmptyStackException extends RuntimeException {

    public EmptyStackException(String message) {
        super(message);
    }

}
