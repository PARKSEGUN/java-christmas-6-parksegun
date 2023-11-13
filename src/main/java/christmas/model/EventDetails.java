package christmas.model;

import static christmas.constants.OutputMessage.GIFT_INFO_FORMAT;
import static christmas.constants.OutputMessage.NO_GIFT_FORMAT;
import static christmas.constants.model.EventConstants.NO_DISCOUNT;
import static christmas.constants.model.EventName.GIFT_EVENT;
import static christmas.constants.model.Menu.CHAMPAGNE;

import christmas.constants.model.EventName;
import java.text.DecimalFormat;
import java.util.Map;

public class EventDetails {

    private final Map<EventName, Integer> details;

    private EventDetails(Map<EventName, Integer> details) {
        this.details = details;
    }

    public static EventDetails from(Map<EventName, Integer> details) {
        return new EventDetails(details);
    }

    public int findAllDiscount() {
        return details.values().stream()
                .mapToInt(i -> i)
                .sum();
    }

    public String giftInfoToString() {
        if (details.get(GIFT_EVENT) == CHAMPAGNE.getPrice()) {
            return String.format(GIFT_INFO_FORMAT.getMessage(), CHAMPAGNE.getName());
        }
        return NO_GIFT_FORMAT.getMessage();
    }

    public String discountInfoToString() {
        if (findAllDiscount() == NO_DISCOUNT) {
            return "없음";
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        StringBuilder discountInfo = new StringBuilder();
        for (EventName eventName : details.keySet()) {
            Integer discount = details.get(eventName);
            if (discount != NO_DISCOUNT) {
                discountInfo.append(eventName.getEventName()).append(": -").append(decimalFormat.format(discount))
                        .append("원\n");
            }
        }
        return discountInfo.toString();
    }
}
