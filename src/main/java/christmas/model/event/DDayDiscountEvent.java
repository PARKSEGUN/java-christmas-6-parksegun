package christmas.model.event;


import static christmas.constants.model.EventConstants.D_DAY_EVENT_DEFAULT_DISCOUNT;
import static christmas.constants.model.EventConstants.NO_DISCOUNT;
import static christmas.constants.model.EventName.D_DAY_DISCOUNT;

import christmas.constants.model.EventName;
import christmas.model.VisitDate;

public class DDayDiscountEvent implements VisitDateEvent {

    private static final int INCREASE_UNIT = 100;
    private static final int START_DATE = 1;
    private static final int END_DATE = 25;

    private final EventName eventName = D_DAY_DISCOUNT;

    @Override
    public int findDiscount(VisitDate visitDate) {
        int date = visitDate.getDate();
        if ((date < START_DATE) || (date > END_DATE)) {
            return NO_DISCOUNT;
        }
        return D_DAY_EVENT_DEFAULT_DISCOUNT + ((date - START_DATE) * INCREASE_UNIT);
    }

    @Override
    public EventName getEventName() {
        return eventName;

    }


}
