package christmas.validator;

import christmas.exception.InvalidDateException;

public class InputValidator {
    private static final String NUMBER_REGEX = "[0-9]+";


    public static void notCorrectNumber(String input) {
        notNumber(input);   //outNumberRange에 들어오게되면 숫자를 판단하는 의미이기에 먼저 숫자인지를 판단한다.
        overNumberRange(input);
    }

    private static void overNumberRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw InvalidDateException.invalidDateException;
        }
    }

    private static void notNumber(String input) {
        if (isNotMatchRegex(input)) {
            throw InvalidDateException.invalidDateException;
        }
    }

    private static boolean isNotMatchRegex(String input) {
        if (input.matches(InputValidator.NUMBER_REGEX)) {
            return false;
        }
        return true;
    }
}
