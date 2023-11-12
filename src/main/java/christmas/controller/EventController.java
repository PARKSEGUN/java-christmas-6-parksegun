package christmas.controller;

import static christmas.constants.ErrorMessage.INVALID_DATE_MESSAGE;
import static christmas.constants.OutputMessage.REQUEST_DATE_MESSAGE;

import christmas.constants.OutputMessage;
import christmas.domain.Player;
import christmas.domain.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {

    private final OutputView outputView;
    private final InputView inputView;

    public EventController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        VisitDate visitDate = createVisitDate();
        Player player = Player.from(visitDate);
        player.calculateDiscount();
        outputView.printRequestMessage(OutputMessage.REQUEST_ORDER_MESSAGE);
        inputView.readOrders();
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
}
