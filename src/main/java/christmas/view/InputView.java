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
        InputValidator.notCorrectNumber(input);
        return Integer.parseInt(input);
    }

    public List<String> readOrders() {
        while (true) {
            try {
                return tryReadOrders();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_ORDER_MESSAGE);
            }
        }
    }

    private List<String> tryReadOrders() {
        String input = Console.readLine();
        readOrderValidate(input);
        return Arrays.stream(input.split(SPLIT_SIGN)).toList();
    }

    private void readOrderValidate(String input) {
        InputValidator.endOfInputNotSplitSign(input);
        InputValidator.splitInputEmpty(input);
        List<String> splitInput = Arrays.stream(input.split(SPLIT_SIGN)).toList();
        splitInput.forEach(InputValidator::notOneCountDistinguishSign);
        splitInput.stream()
                .map(this::findOrderCount)
                .forEach(InputValidator::notCorrectNumber);
    }

    private String findOrderCount(String input) {
        return input.substring(input.indexOf(DISTINGUISH_SIGN_TO_CHAR) + 1);
    }

}