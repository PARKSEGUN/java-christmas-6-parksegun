package christmas.exception;

import static christmas.constants.ErrorMessage.INVALID_DATE_MESSAGE;

/*
 *   잘못된 방문날짜 정보에 대한 Exception
 * */

public class InvalidDateException extends IllegalArgumentException {

    public static final InvalidDateException exception = new InvalidDateException();

    private InvalidDateException() {
        super(INVALID_DATE_MESSAGE.getMessage());
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
