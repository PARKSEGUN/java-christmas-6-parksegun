package christmas.model.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.model.EventName;
import christmas.model.Orders;
import christmas.model.VisitDate;
import christmas.service.EventService;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WeekendDiscountEventTest {
    private static final int DEFAULT_DISCOUNT = 2023;
    private static final int NO_DISCOUNT = 0;
    private final EventService eventService = new EventService();

    @ParameterizedTest
    @DisplayName("주말은 메인메뉴당 2023원 할인")
    @MethodSource
    void weekendDiscount(List<String> splitInputs, VisitDate visitDate, int expectResult) {
        //given
        Orders orders = Orders.fromInput(splitInputs);
        Map<EventName, Integer> eventDetails = eventService.calculateDiscount(visitDate, orders);
        //when
        Integer result = eventDetails.get(EventName.WEEKEND_DISCOUNT);
        //then
        assertThat(result).isEqualTo(expectResult);
    }

    private static Stream<Arguments> weekendDiscount() {
        return Stream.of(
                Arguments.of(List.of("티본스테이크-1", "아이스크림-1", "타파스-3", "제로콜라-4"), VisitDate.from(8), DEFAULT_DISCOUNT),
                Arguments.of(List.of("티본스테이크-2", "아이스크림-1", "타파스-1", "제로콜라-1"), VisitDate.from(9),
                        DEFAULT_DISCOUNT * 2),
                Arguments.of(List.of("티본스테이크-4", "아이스크림-1", "타파스-1", "제로콜라-1"), VisitDate.from(22),
                        DEFAULT_DISCOUNT * 4),
                Arguments.of(List.of("티본스테이크-8", "아이스크림-1", "타파스-1", "제로콜라-1"), VisitDate.from(23),
                        DEFAULT_DISCOUNT * 8)
        );
    }

    @ParameterizedTest
    @DisplayName("평일이면 할인은 없다")
    @MethodSource
    void weekdayNoDiscount(List<String> splitInputs, VisitDate visitDate) {
        //given
        Orders orders = Orders.fromInput(splitInputs);
        Map<EventName, Integer> eventDetails = eventService.calculateDiscount(visitDate, orders);
        //when
        Integer result = eventDetails.get(EventName.WEEKEND_DISCOUNT);
        //then
        assertThat(result).isEqualTo(NO_DISCOUNT);
    }

    private static Stream<Arguments> weekdayNoDiscount() {
        return Stream.of(
                Arguments.of(List.of("티본스테이크-1", "아이스크림-1", "타파스-3", "제로콜라-4"), VisitDate.from(4)),
                Arguments.of(List.of("티본스테이크-2", "아이스크림-1", "타파스-1", "제로콜라-1"), VisitDate.from(5)),
                Arguments.of(List.of("티본스테이크-4", "아이스크림-1", "타파스-1", "제로콜라-1"), VisitDate.from(6)),
                Arguments.of(List.of("티본스테이크-8", "아이스크림-1", "타파스-1", "제로콜라-1"), VisitDate.from(7))
        );
    }
}
