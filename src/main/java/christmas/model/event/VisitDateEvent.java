package christmas.model.event;

import christmas.constants.model.EventName;
import christmas.model.VisitDate;

/*
 *   방문 날짜 정보를 이용하는 이벤트 인터페이스
 * */

public interface VisitDateEvent {
    
    int findDiscount(VisitDate visitDate);

    EventName getEventName();
}
