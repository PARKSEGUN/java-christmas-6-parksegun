package christmas.model.event;

<<<<<<< HEAD
=======
import static christmas.constants.model.MenuType.MAIN;

>>>>>>> parksegun
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
<<<<<<< HEAD
        return orders.countMainMenu() * DEFAULT_DISCOUNT;
=======
        return orders.countByMenuType(MAIN) * DEFAULT_DISCOUNT;
>>>>>>> parksegun
    }

    @Override
    public EventName getEventName() {
        return eventName;
    }
}
