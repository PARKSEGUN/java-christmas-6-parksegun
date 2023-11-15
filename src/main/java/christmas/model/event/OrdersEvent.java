package christmas.model.event;

import christmas.constants.model.EventName;
import christmas.model.Orders;

<<<<<<< HEAD
public interface OrdersEvent {

=======
/*
 *   주문 정보를 이용하는 이벤트 인터페이스
 * */

public interface OrdersEvent {
>>>>>>> parksegun

    int findDiscount(Orders orders);

    EventName getEventName();
}
