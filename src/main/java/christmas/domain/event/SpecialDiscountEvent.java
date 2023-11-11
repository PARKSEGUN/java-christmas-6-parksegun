package christmas.domain.event;

import static christmas.constants.domain.EventName.SPECIAL_DISCOUNT;
import static christmas.constants.domain.SpecialDiscountConstants.DEFAULT_DISCOUNT;
import static christmas.constants.domain.SpecialDiscountConstants.NO_DISCOUNT;
import static christmas.constants.domain.SpecialDiscountConstants.START_DATES;

import christmas.constants.domain.EventName;
import christmas.domain.VisitDate;

public class SpecialDiscountEvent implements VisitDateEvent {
    private final EventName eventName = SPECIAL_DISCOUNT;

    @Override
    public int findDiscount(VisitDate visitDate) {
        if (START_DATES.contains(visitDate.getDate())) {
            return DEFAULT_DISCOUNT;
        }
        return NO_DISCOUNT;
    }

    public String getEventName() {
        return eventName.getEventName();
    }
}
