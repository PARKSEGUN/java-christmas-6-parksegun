package christmas.exception;

import static christmas.constants.ErrorMessage.INVALID_ORDER_MESSAGE;

/*
 *   잘못된 주문 정보에 대한 Exception
 * */

public class InvalidOrderException extends IllegalArgumentException {

    public static final InvalidOrderException exception = new InvalidOrderException();

    private InvalidOrderException() {
        super(INVALID_ORDER_MESSAGE.getMessage());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
