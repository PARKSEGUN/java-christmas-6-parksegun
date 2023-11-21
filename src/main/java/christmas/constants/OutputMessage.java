package christmas.constants;

/*
 *   출력에 대한 메시지 담당
 * */

public enum OutputMessage {

    REQUEST_DATE_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    REQUEST_ORDER_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    ORDER_MENU_MESSAGE("\n<주문 메뉴>"),
    ALL_ORDER_PRICE_MESSAGE("<할인 전 총주문 금액>"),
    GIFT_MENU_MESSAGE("\n<증정 메뉴>"),
    DISCOUNT_DETAIL_MESSAGE("\n<혜택 내역>"),
    ALL_DISCOUNT_PRICE_MESSAGE("<총혜택 금액>"),
    EXPECTED_PAYMENT_MESSAGE("\n<할인 후 예상 결제 금액>"),
    EVENT_BADGE_MESSAGE("\n<12월 이벤트 배지>"),
    NOT_APPLY_EVENT("없음");

    public static final String EVENT_PREVIEW_MESSAGE_FORMAT = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public static final String GIFT_INFO_FORMAT = "%s 1개";
    public static final String ORDER_FORMAT = "%s %s개";
    public static final String MONEY_FORMAT = "%s원";
    public static final String DISCOUNT_DETAIL_FORMAT = "%s: -%s원";


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
