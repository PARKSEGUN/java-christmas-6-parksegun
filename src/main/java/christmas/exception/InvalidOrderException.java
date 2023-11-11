package christmas.exception;

import christmas.constants.ErrorMessage;

public class InvalidOrderException extends IllegalArgumentException {
    public static final InvalidOrderException exception = new InvalidOrderException();

    private InvalidOrderException() {
        super(ErrorMessage.INVALID_ORDER_MESSAGE.getMessage());
    }


    // 비효율적인 stackTrace를 막기위해
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
