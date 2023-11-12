package christmas.model.event;

import christmas.constants.model.EventName;
import christmas.model.Orders;

public interface OrdersEvent {


    int findDiscount(Orders orders);

    EventName getEventName();
}
