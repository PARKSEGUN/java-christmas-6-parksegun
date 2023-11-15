package christmas.constants;

<<<<<<< HEAD
public enum ErrorMessage {
=======
/*
 *   에러에 대한 메시지 정보 담당
 * */

public enum ErrorMessage {

>>>>>>> parksegun
    INVALID_DATE_MESSAGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER_MESSAGE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
