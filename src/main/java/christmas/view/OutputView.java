package christmas.view;

import christmas.constants.ErrorMessage;
import christmas.constants.OutputMessage;

public class OutputView {
    public void printErrorMessage(ErrorMessage message) {
        System.out.println(message.getMessage());
    }

    public void printRequestDate(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    public void printMenu() {
        System.out.println("<주문 메뉴>");
        // ...
    }
    // ...
}
