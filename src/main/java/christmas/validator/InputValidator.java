package christmas.validator;

import static christmas.constants.InputConstants.DISTINGUISH_SIGN_TO_CHAR;
import static christmas.constants.InputConstants.EMPTY_INPUT;
import static christmas.constants.InputConstants.NUMBER_REGEX;
import static christmas.constants.InputConstants.ONE_COUNT;
import static christmas.constants.InputConstants.SPLIT_SIGN;
import static christmas.constants.InputConstants.SPLIT_SIGN_TO_CHAR;

import christmas.exception.InvalidDateException;
import christmas.exception.InvalidOrderException;
import java.util.Arrays;
import java.util.List;

public class InputValidator {


    public static void notCorrectNumber(String input) {
        notNumber(input);   //outNumberRange에 들어오게되면 숫자를 판단하는 의미이기에 먼저 숫자인지를 판단한다.
        overNumberRange(input);
    }

    private static void overNumberRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw InvalidDateException.exception;
        }
    }

    private static void notNumber(String input) {
        if (isNotMatchRegex(input)) {
            throw InvalidDateException.exception;
        }
    }

    private static boolean isNotMatchRegex(String input) {
        if (input.matches(NUMBER_REGEX)) {
            return false;
        }
        return true;
    }

    public static void splitInputEmpty(String input) {
        List<String> splitInput = Arrays.stream(input.split(SPLIT_SIGN)).toList();
        if (splitInput.contains(EMPTY_INPUT)) {
            throw InvalidOrderException.exception;
        }
    }

    public static void notOneCountDistinguishSign(String input) {
        int signCount = (int) input.chars()
                .filter((c) -> c == DISTINGUISH_SIGN_TO_CHAR)
                .count();
        if (signCount != (ONE_COUNT)) {
            throw InvalidOrderException.exception;
        }
    }

    public static void endOfInputNotSplitSign(String input) {
        char endOfInput = input.charAt(input.length() - 1);
        if (endOfInput == SPLIT_SIGN_TO_CHAR) {
            throw InvalidOrderException.exception;
        }
    }
}
