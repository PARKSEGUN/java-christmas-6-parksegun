package christmas.model;

import christmas.constants.model.EventName;
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
}
