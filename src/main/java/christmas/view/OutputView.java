package christmas.view;

public class OutputView {
    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printRequestMessage(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    public void printMenu() {
        System.out.println("<주문 메뉴>");
        // ...
    }
    // ...
}
