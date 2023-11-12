package christmas.model;

public class Player {

    private final VisitDate visitDate;
    private final Orders orders;
    private final EventDetails eventDetails;


    private Player(VisitDate visitDate, Orders orders) {
        this.visitDate = visitDate;
        this.eventDetails = EventDetails.initialized();
        this.orders = orders;
    }

    public static Player of(VisitDate visitDate, Orders orders) {
        return new Player(visitDate, orders);
    }


    public VisitDate getVisitDate() {
        return visitDate;
    }

    public Orders getOrders() {
        return orders;
    }

}
