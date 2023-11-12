package christmas.controller;

import static christmas.constants.ErrorMessage.INVALID_DATE_MESSAGE;
import static christmas.constants.ErrorMessage.INVALID_ORDER_MESSAGE;
import static christmas.constants.OutputMessage.REQUEST_DATE_MESSAGE;

import christmas.constants.OutputMessage;
import christmas.model.EventDetails;
import christmas.model.Orders;
import christmas.model.VisitDate;
import christmas.service.EventService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {

    private final EventService eventService;
    private final OutputView outputView;
    private final InputView inputView;

    public EventController(EventService eventService, OutputView outputView, InputView inputView) {
        this.eventService = eventService;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        VisitDate visitDate = createVisitDate();
        Orders orders = createOrders();
        EventDetails eventDetails = EventDetails.from(eventService.calculateDiscount(visitDate, orders));
        System.out.println(eventDetails);
    }

    private VisitDate createVisitDate() {
        outputView.printRequestMessage(REQUEST_DATE_MESSAGE);
        while (true) {
            try {
                return VisitDate.from(inputView.readVisitDate());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_DATE_MESSAGE);
            }
        }
    }

    private Orders createOrders() {
        outputView.printRequestMessage(OutputMessage.REQUEST_ORDER_MESSAGE);
        while (true) {
            try {
                return Orders.fromInput(inputView.readOrders());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_ORDER_MESSAGE);
            }
        }
    }
}
