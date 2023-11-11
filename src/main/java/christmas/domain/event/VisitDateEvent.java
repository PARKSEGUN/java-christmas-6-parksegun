package christmas.domain.event;

import christmas.domain.VisitDate;

public interface VisitDateEvent {

    int findDiscount(VisitDate visitDate);
}
