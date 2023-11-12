package christmas.model.event;

import static christmas.constants.model.EventConstants.NO_DISCOUNT;
import static christmas.constants.model.EventConstants.SPECIAL_EVENT_DEFAULT_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.VisitDate;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SpecialDiscountEventTest {
    private final SpecialDiscountEvent specialDiscountEvent = new SpecialDiscountEvent();

    @ParameterizedTest
    @DisplayName("별이 붙지 않은 날짜는 할인 없이 없다.")
    @MethodSource
    void noStarDateNoDiscount(VisitDate visitDate) {
        //given
        //when
        int result = specialDiscountEvent.findDiscount(visitDate);
        //then
        assertThat(result).isEqualTo(NO_DISCOUNT);
    }

    private static Stream<Arguments> noStarDateNoDiscount() {
        return Stream.of(
                Arguments.of(VisitDate.from(4)),
                Arguments.of(VisitDate.from(5)),
                Arguments.of(VisitDate.from(6)),
                Arguments.of(VisitDate.from(11)),
                Arguments.of(VisitDate.from(18))
        );
    }

    @ParameterizedTest
    @DisplayName("별이 붙은 날짜는 1000원을 할인한다.")
    @MethodSource
    void starDateDiscount(VisitDate visitDate) {
        //given
        //when
        int result = specialDiscountEvent.findDiscount(visitDate);
        //then
        assertThat(result).isEqualTo(SPECIAL_EVENT_DEFAULT_DISCOUNT);
    }

    private static Stream<Arguments> starDateDiscount() {
        return Stream.of(
                Arguments.of(VisitDate.from(3)),
                Arguments.of(VisitDate.from(10)),
                Arguments.of(VisitDate.from(17)),
                Arguments.of(VisitDate.from(24)),
                Arguments.of(VisitDate.from(25)),
                Arguments.of(VisitDate.from(31))
        );
    }
}
