package christmas.view;

import static christmas.constants.ErrorMessage.INVALID_DATE_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.InputValidator;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public int readDate() {
        while (true) {
            try {
                return tryReadDate();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_DATE_MESSAGE);
            }
        }
    }

    private int tryReadDate() {
        String input = Console.readLine();
        InputValidator.notCorrectNumber(input);
        return Integer.parseInt(input);
    }
    // ...
}