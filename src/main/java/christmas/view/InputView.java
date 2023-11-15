package christmas.view;

<<<<<<< HEAD
import static christmas.constants.ErrorMessage.INVALID_DATE_MESSAGE;
import static christmas.constants.ErrorMessage.INVALID_ORDER_MESSAGE;
import static christmas.constants.InputConstants.DISTINGUISH_SIGN_TO_CHAR;
import static christmas.constants.InputConstants.SPLIT_SIGN;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.InputValidator;
=======
import static christmas.constants.InputConstants.INPUT_ORDER_REGEX;
import static christmas.constants.InputConstants.SPLIT_SIGN;
import static christmas.constants.InputConstants.SPLIT_SIGN_TO_CHAR;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.InvalidOrderException;
>>>>>>> parksegun
import java.util.Arrays;
import java.util.List;

/*
 *   입력 담당
 * */

public class InputView {

    public int readVisitDate() {
<<<<<<< HEAD
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
=======
        String input = Console.readLine();
>>>>>>> parksegun
        return Integer.parseInt(input);
    }

    public List<String> readOrders() {
<<<<<<< HEAD
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
        //    InputValidator.splitInputEmpty(input);
        List<String> splitInput = Arrays.stream(input.split(SPLIT_SIGN)).toList();
        splitInput.forEach(InputValidator::notOneCountDistinguishSign);
        splitInput.stream()
                .map(this::findOrderCount)
                .forEach(InputValidator::notCorrectNumber);
    }

    private String findOrderCount(String input) {
        return input.substring(input.indexOf(DISTINGUISH_SIGN_TO_CHAR) + 1);
    }

=======
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
>>>>>>> parksegun
}