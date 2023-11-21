package christmas.model.event;

import static christmas.constants.model.EventConstants.NO_DISCOUNT;
import static christmas.constants.model.EventConstants.SPECIAL_EVENT_DEFAULT_DISCOUNT;
import static christmas.constants.model.EventName.SPECIAL_DISCOUNT;

import christmas.constants.model.EventName;
import christmas.model.VisitDate;
import java.util.List;

/*
 *   특별 할인 이벤트를 담당
 * */

public class SpecialDiscountEvent implements VisitDateEvent {

    private static final List<Integer> STAR_DATES = List.of(3, 10, 17, 24, 25, 31);

    private final EventName eventName = SPECIAL_DISCOUNT;

    @Override
    public int findDiscount(VisitDate visitDate) {
        if (STAR_DATES.contains(visitDate.getDate())) {
            return SPECIAL_EVENT_DEFAULT_DISCOUNT;
        }
        return NO_DISCOUNT;
    }

    @Override
    public EventName getEventName() {
        return eventName;
    }
}
