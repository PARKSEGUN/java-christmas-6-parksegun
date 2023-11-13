package christmas.model.event;

import static christmas.constants.model.MenuType.DESSERT;

import christmas.constants.model.EventName;
import christmas.model.Orders;

public class WeekdayDiscountEvent implements OrdersEvent {

    private static final int DEFAULT_DISCOUNT = 2023;
    private final EventName eventName = EventName.WEEKDAY_DISCOUNT;

    @Override
    public int findDiscount(Orders orders) {
        return orders.countByMenuType(DESSERT) * DEFAULT_DISCOUNT;
    }

    @Override
    public EventName getEventName() {
        return eventName;
    }
}
