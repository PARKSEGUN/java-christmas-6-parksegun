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

public class WeekdayDiscountEventTest {
    private static final int DEFAULT_DISCOUNT = 2023;
    private static final int NO_DISCOUNT = 0;
    private final EventService eventService = new EventService();


    @ParameterizedTest
    @DisplayName("평일은 디저트당 2023원 할인")
    @MethodSource
    void weekdayDiscount(List<String> splitInputs, VisitDate visitDate, int expectResult) {
        //given
        Orders orders = Orders.fromInput(splitInputs);
        Map<EventName, Integer> eventDetails = eventService.calculateDiscount(visitDate, orders);
        //when
        Integer result = eventDetails.get(EventName.WEEKDAY_DISCOUNT);
        //then
        assertThat(result).isEqualTo(expectResult);
    }

    private static Stream<Arguments> weekdayDiscount() {
        return Stream.of(
                Arguments.of(List.of("티본스테이크-1", "아이스크림-1", "타파스-3", "제로콜라-4"), VisitDate.from(4), DEFAULT_DISCOUNT),
                Arguments.of(List.of("티본스테이크-1", "아이스크림-2", "타파스-1", "제로콜라-1"), VisitDate.from(5),
                        DEFAULT_DISCOUNT * 2),
                Arguments.of(List.of("티본스테이크-1", "아이스크림-4", "타파스-1", "제로콜라-1"), VisitDate.from(6),
                        DEFAULT_DISCOUNT * 4),
                Arguments.of(List.of("티본스테이크-1", "아이스크림-8", "타파스-1", "제로콜라-1"), VisitDate.from(7),
                        DEFAULT_DISCOUNT * 8)
        );
    }

    @ParameterizedTest
    @DisplayName("주말이면 할인은 없다")
    @MethodSource
    void weekendNoDiscount(List<String> splitInputs, VisitDate visitDate) {
        //given
        Orders orders = Orders.fromInput(splitInputs);
        Map<EventName, Integer> eventDetails = eventService.calculateDiscount(visitDate, orders);
        //when
        Integer result = eventDetails.get(EventName.WEEKDAY_DISCOUNT);
        //then
        assertThat(result).isEqualTo(NO_DISCOUNT);
    }

    private static Stream<Arguments> weekendNoDiscount() {
        return Stream.of(
                Arguments.of(List.of("티본스테이크-1", "아이스크림-1", "타파스-3", "제로콜라-4"), VisitDate.from(8)),
                Arguments.of(List.of("티본스테이크-1", "아이스크림-2", "타파스-1", "제로콜라-1"), VisitDate.from(9)),
                Arguments.of(List.of("티본스테이크-1", "아이스크림-4", "타파스-1", "제로콜라-1"), VisitDate.from(15)),
                Arguments.of(List.of("티본스테이크-1", "아이스크림-8", "타파스-1", "제로콜라-1"), VisitDate.from(16))
        );
    }
}
