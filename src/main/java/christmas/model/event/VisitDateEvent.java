package christmas.model.event;

import christmas.constants.model.EventName;
import christmas.model.VisitDate;

public interface VisitDateEvent {


    int findDiscount(VisitDate visitDate);

    EventName getEventName();
}
