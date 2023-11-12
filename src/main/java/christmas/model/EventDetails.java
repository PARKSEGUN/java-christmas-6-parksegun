package christmas.model;

import christmas.constants.model.EventName;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EventDetails {
    private static final int ZERO_DISCOUNT = 0;


    private final Map<EventName, Integer> details;

    public EventDetails(Map<EventName, Integer> details) {
        this.details = details;
    }

    public static EventDetails initialized() {
        return new EventDetails(settingEventDetails());
    }

    private static Map<EventName, Integer> settingEventDetails() {
        Map<EventName, Integer> eventDetails = new HashMap<>();
        Arrays.stream(EventName.values())
                .forEach(eventName -> eventDetails.put(eventName, ZERO_DISCOUNT));
        return new HashMap<>(eventDetails);
    }

    //자료구조 처럼 사용하기위함
    public void addDiscount(EventName eventName, int discount) {
        Integer originalDiscount = details.get(eventName);
        details.put(eventName, originalDiscount + discount);
    }

    //불변성을 지키기위한 메서드 수정
    public Map<EventName, Integer> getDetails() {
        return Collections.unmodifiableMap(new HashMap<>(details));
    }
}
