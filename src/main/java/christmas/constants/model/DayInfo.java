package christmas.constants.model;

import christmas.exception.InvalidDateException;
import java.util.Arrays;

public enum DayInfo {

    MONDAY(4),
    TUESDAY(5),
    WEDNESDAY(6),
    THURSDAY(0),
    FRIDAY(1),
    SATURDAY(2),
    SUNDAY(3);

    private static final int ALL_DAY_COUNT = 7;

    private final int startDate;

    DayInfo(int startDate) {
        this.startDate = startDate;
    }

    public static DayInfo findByDate(int startDate) {
        return Arrays.stream(values())
                .filter(value -> value.startDate == (startDate % ALL_DAY_COUNT))
                .findFirst()
                .orElseThrow(() -> InvalidDateException.exception);
    }

    public boolean isWeekend() {
        return (this.equals(FRIDAY)) || (this.equals(SATURDAY));
    }
}