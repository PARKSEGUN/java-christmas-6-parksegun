package christmas.model;

import static christmas.constants.OutputMessage.EVENT_DETAIL_FORMAT;
import static christmas.constants.OutputMessage.GIFT_INFO_FORMAT;
import static christmas.constants.OutputMessage.NO_GIFT_FORMAT;
import static christmas.constants.model.EventConstants.NO_DISCOUNT;
import static christmas.constants.model.EventName.GIFT_EVENT;
import static christmas.constants.model.Menu.CHAMPAGNE;

import christmas.constants.model.EventName;
import java.text.DecimalFormat;
import java.util.Map;

/*
 *  이벤트의 할인금액에 대한 정보 담당
 * */

public class EventDetails {

    private final Map<EventName, Integer> details;

    private EventDetails(Map<EventName, Integer> details) {
        this.details = details;
    }

    public static EventDetails from(Map<EventName, Integer> details) {
        return new EventDetails(details);
    }

    public int sumOfDiscounts() {
        return details.values().stream()
                .mapToInt(i -> i)
                .sum();
    }

    public String toStringGiftEvent() {
        if (details.get(GIFT_EVENT) == CHAMPAGNE.getPrice()) {
            return String.format(GIFT_INFO_FORMAT.getMessage(), CHAMPAGNE.getName());
        }
        return NO_GIFT_FORMAT.getMessage();
    }

    public String toStringDiscountInfo() {
        DecimalFormat decimalFormat = new DecimalFormat();
        StringBuilder discountInfo = new StringBuilder();
        if (sumOfDiscounts() == NO_DISCOUNT) {
            return "없음";
        }
        for (EventName eventName : details.keySet()) {
            discountInfo.append(makeDiscountInfo(decimalFormat, eventName));
        }
        return discountInfo.toString();
    }

    private String makeDiscountInfo(DecimalFormat decimalFormat, EventName eventName) {
        Integer discount = details.get(eventName);
        if (discount > NO_DISCOUNT) {
            return String.format(
                    EVENT_DETAIL_FORMAT.getMessage(), eventName.getName(), decimalFormat.format(discount)
            );
        }
        return "";
    }
}
