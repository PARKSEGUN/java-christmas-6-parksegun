package christmas;

import christmas.controller.EventController;
import christmas.service.EventService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        EventController eventController = new EventController(new EventService(), new OutputView(), new InputView());
        eventController.run();

    }
}
