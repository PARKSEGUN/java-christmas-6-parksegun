package christmas.domain;

import christmas.domain.event.DDayDiscountEvent;

public class Player {
    private final VisitDate visitDate;
    private final EventDetails eventDetails;

    private final DDayDiscountEvent dDayDiscountEvent;

    private Player(VisitDate visitDate) {
        this.visitDate = visitDate;
        this.eventDetails = EventDetails.initialized();
        this.dDayDiscountEvent = new DDayDiscountEvent();
    }

    public static Player from(VisitDate visitDate) {
        return new Player(visitDate);
    }


    public void calculateDiscount() {
        int discount = dDayDiscountEvent.findDiscount(visitDate);
        eventDetails.addDiscount(dDayDiscountEvent.eventName, discount);
    }
}
