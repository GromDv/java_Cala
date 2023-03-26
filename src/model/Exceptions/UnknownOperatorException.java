package model.Exceptions;

public class UnknownOperatorException extends Exception {
    public UnknownOperatorException(String message) {
        super(String.format("В выражении есть непонятный знак: %s, попробуйте заново.", message));
    }
}
