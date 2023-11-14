package christmas.model;

import christmas.exception.InvalidDateException;

/*
 *   방문 날짜 정보 담당
 * */

public class VisitDate {

    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    private final int date;

    private VisitDate(int date) {
        validateDate(date);
        this.date = date;
    }

    public static VisitDate from(int date) {
        return new VisitDate(date);
    }

    private void validateDate(int date) {
        if ((date < MIN_DATE) || (date > MAX_DATE)) {
            throw InvalidDateException.invalidDateException;
        }
    }

    @Override
    public String toString() {
        return "(방문날짜)" + date;
    }

    public int getDate() {
        return date;
    }
}
