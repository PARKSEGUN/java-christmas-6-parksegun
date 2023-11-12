package christmas.model.event;

import static christmas.constants.model.EventConstants.D_DAY_EVENT_DEFAULT_DISCOUNT;
import static christmas.constants.model.EventConstants.NO_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.VisitDate;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DDayDiscountEventTest {
    private static final int INCREASE_UNIT = 100;

    private final DDayDiscountEvent dDayDiscountEvent = new DDayDiscountEvent();

    @ParameterizedTest
    @DisplayName("1 ~ 25 일 사이를 벗어난다면 할인 없이 없다.")
    @MethodSource
    void outDEventDayRange(VisitDate visitDate) {
        //given
        //when
        int result = dDayDiscountEvent.findDiscount(visitDate);
        //then
        assertThat(result).isEqualTo(NO_DISCOUNT);
    }

    private static Stream<Arguments> outDEventDayRange() {
        return Stream.of(
                Arguments.of(VisitDate.from(26)),
                Arguments.of(VisitDate.from(27)),
                Arguments.of(VisitDate.from(28)),
                Arguments.of(VisitDate.from(29)),
                Arguments.of(VisitDate.from(30))
        );
    }

    @ParameterizedTest
    @DisplayName("얼마의 할인이 적용되는 구한다.")
    @MethodSource
    void findDiscount(VisitDate visitDate, int expect) {
        //given
        //when
        int result = dDayDiscountEvent.findDiscount(visitDate);
        //then
        assertThat(result).isEqualTo(expect);
    }

    private static Stream<Arguments> findDiscount() {
        return Stream.of(
                Arguments.of(VisitDate.from(1), D_DAY_EVENT_DEFAULT_DISCOUNT + INCREASE_UNIT * 0),
                Arguments.of(VisitDate.from(2), D_DAY_EVENT_DEFAULT_DISCOUNT + INCREASE_UNIT * 1),
                Arguments.of(VisitDate.from(3), D_DAY_EVENT_DEFAULT_DISCOUNT + INCREASE_UNIT * 2),
                Arguments.of(VisitDate.from(4), D_DAY_EVENT_DEFAULT_DISCOUNT + INCREASE_UNIT * 3),
                Arguments.of(VisitDate.from(5), D_DAY_EVENT_DEFAULT_DISCOUNT + INCREASE_UNIT * 4)
        );
    }
}
