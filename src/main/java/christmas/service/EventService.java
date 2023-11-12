package christmas.service;

import christmas.domain.Orders;
import christmas.domain.VisitDate;
import christmas.domain.event.DDayDiscountEvent;
import christmas.domain.event.SpecialDiscountEvent;
import java.util.HashMap;
import java.util.Map;

public class EventService {

    private final DDayDiscountEvent dDayDiscountEvent;
    private final SpecialDiscountEvent specialDiscountEvent;

    public EventService() {
        this.dDayDiscountEvent = new DDayDiscountEvent();
        this.specialDiscountEvent = new SpecialDiscountEvent();
    }

    public Map<String, Integer> calculateDiscount(VisitDate visitDate, Orders orders) {
        Map<String, Integer> eventDetails = new HashMap<>();
        eventDetails.put(dDayDiscountEvent.getEventName(), calculateDDayDiscount(visitDate));
        eventDetails.put(specialDiscountEvent.getEventName(), calculateSpecialDiscount(visitDate));
        return eventDetails;
    }

    private int calculateDDayDiscount(VisitDate visitDate) {
        return dDayDiscountEvent.findDiscount(visitDate);
    }

    private int calculateSpecialDiscount(VisitDate visitDate) {
        return specialDiscountEvent.findDiscount(visitDate);
    }
}
