package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.VisitDate;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DDayDiscountEventTest {
    private final DDayDiscountEvent dDayDiscountEvent = new DDayDiscountEvent();
    private final int NO_DISCOUNT = 0;

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
                Arguments.of(VisitDate.from(1), 1000),
                Arguments.of(VisitDate.from(2), 1100),
                Arguments.of(VisitDate.from(3), 1200),
                Arguments.of(VisitDate.from(4), 1300),
                Arguments.of(VisitDate.from(5), 1400)
        );
    }
}
