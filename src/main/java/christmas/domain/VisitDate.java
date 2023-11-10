package christmas.domain;

import static christmas.constants.ErrorMessage.INVALID_DATE_MESSAGE;

public class VisitDate {
    private final int date;

    private VisitDate(int date) {
        validate(date);
        this.date = date;
    }

    public static VisitDate from(int date) {
        return new VisitDate(date);
    }

    private void validate(int date) {
        if ((date < 1) || (date > 31)) {
            throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
        }
    }

    public int getDate() {
        return date;
    }
}
