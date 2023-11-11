package christmas.domain.event;

import static christmas.constants.domain.SpecialDiscountConstants.DEFAULT_DISCOUNT;
import static christmas.constants.domain.SpecialDiscountConstants.NO_DISCOUNT;
import static christmas.constants.domain.SpecialDiscountConstants.START_DATES;

import christmas.domain.VisitDate;

public class SpecialDiscountVisitDateEvent implements VisitDateEvent {
    private final String eventName = "특별 할인";

    @Override
    public int findDiscount(VisitDate visitDate) {
        if (START_DATES.contains(visitDate.getDate())) {
            return DEFAULT_DISCOUNT;
        }
        return NO_DISCOUNT;
    }

    public String getEventName() {
        return eventName;
    }
}
