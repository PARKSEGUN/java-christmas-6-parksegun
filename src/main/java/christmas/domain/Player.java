package christmas.domain;

import christmas.domain.event.DDayDiscountEvent;
import christmas.domain.event.SpecialDiscountEvent;
import java.util.Map;

public class Player {

    private final VisitDate visitDate;
    private final EventDetails eventDetails;

    private final DDayDiscountEvent dDayDiscountEvent;
    private final SpecialDiscountEvent specialDiscountEvent;

    private Player(VisitDate visitDate) {
        this.visitDate = visitDate;
        this.eventDetails = EventDetails.initialized();
        this.dDayDiscountEvent = new DDayDiscountEvent();
        this.specialDiscountEvent = new SpecialDiscountEvent();
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
        int discount = specialDiscountEvent.findDiscount(visitDate);
        eventDetails.addDiscount(specialDiscountEvent.getEventName(), discount);
    }

    public Map<String, Integer> getEventDetails() {
        return eventDetails.getDetails();
    }
}
