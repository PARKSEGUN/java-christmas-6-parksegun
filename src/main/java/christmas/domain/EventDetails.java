package christmas.domain;

import christmas.constants.domain.EventName;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EventDetails {
    private static final int ZERO_DISCOUNT = 0;


    private final Map<String, Integer> details;

    public EventDetails(Map<String, Integer> details) {
        this.details = details;
    }

    public static EventDetails initialized() {
        return new EventDetails(settingEventDetails());
    }

    private static Map<String, Integer> settingEventDetails() {
        Map<String, Integer> eventDetails = new HashMap<>();
        Arrays.stream(EventName.values())
                .forEach(eventName -> eventDetails.put(eventName.getEventName(), ZERO_DISCOUNT));
        return new HashMap<>(eventDetails);
    }

    //자료구조 처럼 사용하기위함
    public void addDiscount(String eventName, int discount) {
        Integer originalDiscount = details.get(eventName);
        details.put(eventName, originalDiscount + discount);
        System.out.println(details);
    }

    //불변성을 지키기위한 메서드 수정
    public Map<String, Integer> getDetails() {
        return Collections.unmodifiableMap(new HashMap<>(details));
    }
}
