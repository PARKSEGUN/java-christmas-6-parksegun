package christmas.constants;

public enum OutputMessage {

    REQUEST_DATE_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    REQUEST_ORDER_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    EVENT_PREVIEW_MESSAGE_FORMAT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    GIFT_INFO_FORMAT("%s 1개"),
    NO_GIFT_FORMAT("없음"),
    ORDER_FORMAT("%s %s개"),
    PRICE_FORMAT("%s원");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
