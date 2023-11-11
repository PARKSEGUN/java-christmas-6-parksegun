package christmas.domain.event;


import static christmas.constants.domain.DDayDiscountConstants.DEFAULT_DISCOUNT;
import static christmas.constants.domain.DDayDiscountConstants.END_DATE;
import static christmas.constants.domain.DDayDiscountConstants.INCREASE_UNIT;
import static christmas.constants.domain.DDayDiscountConstants.NO_DISCOUNT;
import static christmas.constants.domain.DDayDiscountConstants.START_DATE;
import static christmas.constants.domain.EventName.D_DAY_DISCOUNT;

import christmas.constants.domain.EventName;
import christmas.domain.VisitDate;

public class DDayDiscountEvent implements VisitDateEvent {

    private final EventName eventName = D_DAY_DISCOUNT;


    @Override
    public int findDiscount(VisitDate visitDate) {
        int date = visitDate.getDate();
        if ((date < START_DATE) || (date > END_DATE)) {
            return NO_DISCOUNT;
        }
        return DEFAULT_DISCOUNT + ((date - START_DATE) * INCREASE_UNIT);
    }

    public String getEventName() {
        return eventName.getEventName();
    }
}
