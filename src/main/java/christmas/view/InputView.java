package christmas.view;

import static christmas.constants.ErrorMessage.INVALID_DATE_MESSAGE;
import static christmas.constants.ErrorMessage.INVALID_ORDER_MESSAGE;
import static christmas.constants.InputConstants.DISTINGUISH_SIGN_TO_CHAR;
import static christmas.constants.InputConstants.SPLIT_SIGN;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.InputValidator;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public int readVisitDate() {
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
        InputValidator.overNumberMax(input);
        return Integer.parseInt(input);
    }

    public String readOrders() {
        while (true) {
            try {
                tryReadOrders();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_ORDER_MESSAGE);
            }
        }
    }

    private String tryReadOrders() {
        String input = Console.readLine();
        InputValidator.endOfInputNotSplitSign(input);
        InputValidator.splitInputEmpty(input);
        List<String> splitInput = Arrays.stream(input.split(SPLIT_SIGN)).toList();
        splitInput.forEach(InputValidator::notOneCountDistinguishSign);
        splitInput.stream()
                .map(this::findOrderCount)
                .forEach(InputValidator::notCorrectNumber);
        System.out.println(splitInput);
        return input;
    }

    private String findOrderCount(String input) {
        return input.substring(input.indexOf(DISTINGUISH_SIGN_TO_CHAR) + 1);
    }

    // ...
}