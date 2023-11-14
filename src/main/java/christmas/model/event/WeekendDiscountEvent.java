package christmas.model.event;

import christmas.constants.model.EventName;
import christmas.model.Orders;

/*
 *   주말 할인 이벤트를 담당
 * */

public class WeekendDiscountEvent implements OrdersEvent {

    private static final int DEFAULT_DISCOUNT = 2023;

    private final EventName eventName = EventName.WEEKEND_DISCOUNT;

    @Override
    public int findDiscount(Orders orders) {
        return orders.countMainMenu() * DEFAULT_DISCOUNT;
    }

    @Override
    public EventName getEventName() {
        return eventName;
    }
}
