package christmas.model.event;

import static christmas.constants.model.EventConstants.NO_DISCOUNT;

import christmas.constants.model.EventName;
import christmas.model.Orders;

public class GiftEvent implements OrdersEvent {
    private static final int GIFT_CONDITION = 120_000;
    private static final int GIFT_PRICE = 25_000;
    private final EventName eventName = EventName.GIFT_EVENT;

    @Override
    public int findDiscount(Orders orders) {
        if (orders.findSumOfPrice() >= GIFT_CONDITION) {
            return GIFT_PRICE;
        }
        return NO_DISCOUNT;
    }

    @Override
    public EventName getEventName() {
        return eventName;
    }
}
