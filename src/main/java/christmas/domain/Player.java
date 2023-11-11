package christmas.domain;

import christmas.domain.event.DDayDiscountVisitDateEvent;
import christmas.domain.event.SpecialDiscountVisitDateEvent;
import java.util.Map;

public class Player {

    private final VisitDate visitDate;
    private final EventDetails eventDetails;

    private final DDayDiscountVisitDateEvent dDayDiscountEvent;
    private final SpecialDiscountVisitDateEvent specialDiscountVisitDateEvent;

    private Player(VisitDate visitDate) {
        this.visitDate = visitDate;
        this.eventDetails = EventDetails.initialized();
        this.dDayDiscountEvent = new DDayDiscountVisitDateEvent();
        this.specialDiscountVisitDateEvent = new SpecialDiscountVisitDateEvent();
    }

    public static Player from(VisitDate visitDate) {
        return new Player(visitDate);
    }


    public void calculateDiscount() {
        calculateDDayDiscount();
        calculateSpecialDiscount();
    }

    private void calculateDDayDiscount() {
        int discount = dDayDiscountEvent.findDiscount(visitDate);
        eventDetails.addDiscount(dDayDiscountEvent.getEventName(), discount);
    }

    private void calculateSpecialDiscount() {
        int discount = specialDiscountVisitDateEvent.findDiscount(visitDate);
        eventDetails.addDiscount(specialDiscountVisitDateEvent.getEventName(), discount);
    }

    public Map<String, Integer> getEventDetails() {
        return eventDetails.getDetails();
    }
}
