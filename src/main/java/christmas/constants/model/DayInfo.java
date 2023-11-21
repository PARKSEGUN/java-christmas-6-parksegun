package christmas.constants.model;

import java.util.Arrays;

/*
 *   날짜와 요일에 대한 상수 정보 담당
 * */

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
                .orElseThrow(() -> new IllegalArgumentException("날짜에 대한 알맞은 요일이 없을 수 없습니다!"));
    }

    public boolean isWeekend() {
        return (this.equals(FRIDAY)) || (this.equals(SATURDAY));
    }
}