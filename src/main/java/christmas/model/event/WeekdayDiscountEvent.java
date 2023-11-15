package christmas.model.event;

<<<<<<< HEAD
=======
import static christmas.constants.model.MenuType.DESSERT;

>>>>>>> parksegun
import christmas.constants.model.EventName;
import christmas.model.Orders;

/*
 *   평일 할인 이벤트를 담당
 * */

public class WeekdayDiscountEvent implements OrdersEvent {

    private static final int DEFAULT_DISCOUNT = 2023;
    private final EventName eventName = EventName.WEEKDAY_DISCOUNT;

    @Override
    public int findDiscount(Orders orders) {
<<<<<<< HEAD
        return orders.countDessertMenu() * DEFAULT_DISCOUNT;
=======
        return orders.countByMenuType(DESSERT) * DEFAULT_DISCOUNT;
>>>>>>> parksegun
    }

    @Override
    public EventName getEventName() {
        return eventName;
    }
}
