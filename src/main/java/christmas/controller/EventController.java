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
<<<<<<< HEAD
import java.text.DecimalFormat;
import java.util.List;
=======

/*
 *   프로젝트의 흐름을 담당
 * */
>>>>>>> parksegun

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
        outputView.printEventPreview(visitDate, orders, eventDetails);
<<<<<<< HEAD

    }

    private void addPreviewInfoMessage(List<String> previewInfo, DecimalFormat decimalFormat) {

=======
>>>>>>> parksegun
    }

    private VisitDate createVisitDate() {
        outputView.printOutputMessage(REQUEST_DATE_MESSAGE);
        while (true) {
            try {
                return VisitDate.from(inputView.readVisitDate());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_DATE_MESSAGE);
            }
        }
    }

    private Orders createOrders() {
        outputView.printOutputMessage(OutputMessage.REQUEST_ORDER_MESSAGE);
        while (true) {
            try {
                return Orders.fromInput(inputView.readOrders());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_ORDER_MESSAGE);
            }
        }
    }
}
