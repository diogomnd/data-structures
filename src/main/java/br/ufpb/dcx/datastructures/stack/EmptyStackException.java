package br.ufpb.dcx.datastructures.stack;

/**
 * Exception thrown if the stack is empty
 */
public class EmptyStackException extends RuntimeException {

    public EmptyStackException(String err) {
        super(err);
    }

}
