package christmas.view;

import static christmas.constants.InputConstants.INPUT_ORDER_REGEX;
import static christmas.constants.InputConstants.SPLIT_SIGN;
import static christmas.constants.InputConstants.SPLIT_SIGN_TO_CHAR;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.InvalidOrderException;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private final OutputView outputView;

    public InputView() {
        this.outputView = new OutputView();
    }

    public int readVisitDate() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public List<String> readOrders() {
        String input = Console.readLine();
        validateReadOrder(input);
        return Arrays.stream(input.split(SPLIT_SIGN)).toList();
    }

    private void validateReadOrder(String input) {
        List<String> splitInput = Arrays.stream(input.split(SPLIT_SIGN)).toList();
        splitInput.forEach(this::validateMatchOrderRegex);
        validateEndIsSplitSign(input);
    }

    private void validateEndIsSplitSign(String input) {
        char endOfInput = input.charAt(input.length() - 1);
        if (endOfInput == SPLIT_SIGN_TO_CHAR) {
            throw InvalidOrderException.exception;
        }
    }

    private void validateMatchOrderRegex(String input) {
        if (input.matches(INPUT_ORDER_REGEX)) {
            return;
        }
        throw InvalidOrderException.exception;
    }
}