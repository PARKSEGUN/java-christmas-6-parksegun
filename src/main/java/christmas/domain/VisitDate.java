package christmas.domain;

import christmas.exception.InvalidDateException;

public class VisitDate {

    private final int MIN_DATE = 1;
    private final int MAX_DATE = 31;

    private final int date;

    private VisitDate(int date) {
        validate(date);
        this.date = date;
    }

    public static VisitDate from(int date) {
        return new VisitDate(date);
    }

    private void validate(int date) {
        if ((date < MIN_DATE) || (date > MAX_DATE)) {
            throw InvalidDateException.invalidDateException;
        }
    }

    public int getDate() {
        return date;
    }
}
