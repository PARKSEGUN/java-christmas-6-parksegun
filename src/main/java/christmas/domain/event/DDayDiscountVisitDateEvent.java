package christmas.domain.event;


import static christmas.constants.domain.DDayDiscountConstants.DEFAULT_DISCOUNT;
import static christmas.constants.domain.DDayDiscountConstants.END_DATE;
import static christmas.constants.domain.DDayDiscountConstants.INCREASE_UNIT;
import static christmas.constants.domain.DDayDiscountConstants.NO_DISCOUNT;
import static christmas.constants.domain.DDayDiscountConstants.START_DATE;

import christmas.domain.VisitDate;

public class DDayDiscountVisitDateEvent implements VisitDateEvent {

    private final String eventName = "크리스마스 디데이 할인";


    @Override
    public int findDiscount(VisitDate visitDate) {
        int date = visitDate.getDate();
        if ((date < START_DATE) || (date > END_DATE)) {
            return NO_DISCOUNT;
        }
        return DEFAULT_DISCOUNT + ((date - START_DATE) * INCREASE_UNIT);
    }

    public String getEventName() {
        return eventName;
    }
}
