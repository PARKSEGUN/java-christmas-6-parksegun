package christmas.model.event;

import christmas.constants.model.EventName;
import christmas.model.Orders;

/*
 *   주문 정보를 이용하는 이벤트 인터페이스
 * */

public interface OrdersEvent {

    int findDiscount(Orders orders);

    EventName getEventName();
}
