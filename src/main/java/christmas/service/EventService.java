package christmas.service;

import static christmas.constants.model.EventConstants.NO_DISCOUNT;

import christmas.constants.model.DayInfo;
import christmas.constants.model.EventName;
import christmas.model.Orders;
import christmas.model.VisitDate;
import christmas.model.event.DDayDiscountEvent;
import christmas.model.event.OrdersEvent;
import christmas.model.event.SpecialDiscountEvent;
import christmas.model.event.WeekdayDiscountEvent;
import christmas.model.event.WeekendDiscountEvent;
import java.util.HashMap;
import java.util.Map;

public class EventService {

    private final DDayDiscountEvent dDayDiscountEvent;
    private final SpecialDiscountEvent specialDiscountEvent;
    private final WeekdayDiscountEvent weekdayDiscountEvent;
    private final WeekendDiscountEvent weekendDiscountEvent;

    public EventService() {
        this.dDayDiscountEvent = new DDayDiscountEvent();
        this.specialDiscountEvent = new SpecialDiscountEvent();
        this.weekdayDiscountEvent = new WeekdayDiscountEvent();
        this.weekendDiscountEvent = new WeekendDiscountEvent();
    }

    public Map<EventName, Integer> calculateDiscount(VisitDate visitDate, Orders orders) {
        Map<EventName, Integer> eventDetails = new HashMap<>();
        eventDetails.put(dDayDiscountEvent.getEventName(), dDayDiscountEvent.findDiscount(visitDate));
        eventDetails.put(specialDiscountEvent.getEventName(), specialDiscountEvent.findDiscount(visitDate));
        eventDetails.putAll(calculateWeekDiscount(visitDate, orders));
        return eventDetails;
    }

    private Map<EventName, Integer> calculateWeekDiscount(VisitDate visitDate, Orders orders) {
        DayInfo day = DayInfo.findByDate(visitDate.getDate());
        if (day.isWeekend()) {
            return chooseCorrectEvent(weekendDiscountEvent, weekdayDiscountEvent, orders);
        }
        return chooseCorrectEvent(weekdayDiscountEvent, weekendDiscountEvent, orders);
    }

    private Map<EventName, Integer> chooseCorrectEvent(OrdersEvent leftEvent, OrdersEvent rightEvent, Orders orders) {
        Map<EventName, Integer> eventDetails = new HashMap<>();
        eventDetails.put(leftEvent.getEventName(), leftEvent.findDiscount(orders));
        eventDetails.put(rightEvent.getEventName(), NO_DISCOUNT);
        return eventDetails;
    }

}
