package christmas.service;

import static christmas.constants.model.EventConstants.EVENT_CONDITION_PRICE;
import static christmas.constants.model.EventConstants.NO_DISCOUNT;

import christmas.constants.model.DayInfo;
import christmas.constants.model.EventName;
import christmas.model.Orders;
import christmas.model.VisitDate;
import christmas.model.event.DDayDiscountEvent;
<<<<<<< HEAD
=======
import christmas.model.event.GiftEvent;
>>>>>>> parksegun
import christmas.model.event.OrdersEvent;
import christmas.model.event.SpecialDiscountEvent;
import christmas.model.event.WeekdayDiscountEvent;
import christmas.model.event.WeekendDiscountEvent;
import java.util.HashMap;
import java.util.Map;

/*
 *   모든 이벤트 기능을 담당
 * */

public class EventService {

    private final DDayDiscountEvent dDayDiscountEvent;
    private final SpecialDiscountEvent specialDiscountEvent;
    private final WeekdayDiscountEvent weekdayDiscountEvent;
    private final WeekendDiscountEvent weekendDiscountEvent;
<<<<<<< HEAD
=======
    private final GiftEvent giftEvent;
>>>>>>> parksegun

    public EventService() {
        this.dDayDiscountEvent = new DDayDiscountEvent();
        this.specialDiscountEvent = new SpecialDiscountEvent();
        this.weekdayDiscountEvent = new WeekdayDiscountEvent();
        this.weekendDiscountEvent = new WeekendDiscountEvent();
<<<<<<< HEAD
=======
        this.giftEvent = new GiftEvent();
>>>>>>> parksegun
    }

    public Map<EventName, Integer> calculateDiscount(VisitDate visitDate, Orders orders) {
        if (orders.findSumOfPrice() < EVENT_CONDITION_PRICE) {
            return notApplyEvent();
        }
        Map<EventName, Integer> eventDetails = new HashMap<>();
        eventDetails.put(dDayDiscountEvent.getEventName(), dDayDiscountEvent.findDiscount(visitDate));
        eventDetails.put(specialDiscountEvent.getEventName(), specialDiscountEvent.findDiscount(visitDate));
<<<<<<< HEAD
=======
        eventDetails.put(giftEvent.getEventName(), giftEvent.findDiscount(orders));
>>>>>>> parksegun
        eventDetails.putAll(calculateWeekDiscount(visitDate, orders));
        return eventDetails;
    }

    private Map<EventName, Integer> notApplyEvent() {
        Map<EventName, Integer> applyInfo = new HashMap<>();
        for (EventName eventName : EventName.values()) {
            applyInfo.put(eventName, NO_DISCOUNT);
        }
        return applyInfo;
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
