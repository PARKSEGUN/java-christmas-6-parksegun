package christmas.validator;

import static christmas.constants.ErrorMessage.INVALID_DATE_MESSAGE;

public class InputValidator {
    private static final String NUMBER_REGEX = "[0-9]+";


    public static void overNumberMax(String input) {
        notNumber(input);   //outNumberRange에 들어오게되면 숫자를 판단하는 의미이기에 먼저 숫자인지를 판단한다.
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
        }
    }

    private static void notNumber(String input) {
        if (isNotMatchRegex(input)) {
            throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
        }
    }

    private static boolean isNotMatchRegex(String input) {
        if (input.matches(InputValidator.NUMBER_REGEX)) {
            return false;
        }
        return true;
    }
}
