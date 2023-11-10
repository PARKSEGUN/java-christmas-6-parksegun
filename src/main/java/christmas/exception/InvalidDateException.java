package christmas.exception;

import christmas.constants.ErrorMessage;

public class InvalidDateException extends IllegalArgumentException {
    //발생시마다 호출하는 것이 아닌 한번 띄어 놓고 가져오면서 사용하기 위함(new 생성을 막아주기 위해서)
    public static final InvalidDateException invalidDateException = new InvalidDateException();

    private InvalidDateException() {
        super(ErrorMessage.INVALID_DATE_MESSAGE.getMessage());
    }


    // 비효율적인 stackTrace를 막기위해
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
