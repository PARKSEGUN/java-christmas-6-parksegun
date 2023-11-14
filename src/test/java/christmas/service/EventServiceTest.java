package christmas.service;

import static christmas.constants.model.EventConstants.NO_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.model.EventName;
import christmas.model.EventDetails;
import christmas.model.Orders;
import christmas.model.VisitDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EventServiceTest {
    private final EventService eventService = new EventService();

    @ParameterizedTest
    @DisplayName("총 주문 금액이 10,000원을 넘지 않는다면 이벤트 참여 불가")
    @MethodSource
    void sumOfOrderFailedCondition(List<String> splitInputs, VisitDate visitDate) {
        //given
        Orders orders = Orders.fromInput(splitInputs);
        Map<EventName, Integer> discountDetail = eventService.calculateDiscount(visitDate, orders);
        EventDetails eventDetails = EventDetails.from(discountDetail);
        //when
        int sumOfDiscount = eventDetails.findSumOfDiscount();
        //then
        assertThat(sumOfDiscount).isEqualTo(NO_DISCOUNT);
    }

    private static Stream<Arguments> sumOfOrderFailedCondition() {
        return Stream.of(
                Arguments.of(List.of("타파스-1"), VisitDate.from(8)),
                Arguments.of(List.of("시저샐러드-1"), VisitDate.from(9)),
                Arguments.of(List.of("아이스크림-1"), VisitDate.from(22)),
                Arguments.of(List.of("양송이수프-1"), VisitDate.from(23))
        );
    }

    @ParameterizedTest
    @DisplayName("총 주문 금액이 10,000원을 넘는 다면 이벤트 참여 가능")
    @MethodSource
    void sumOfOrderSuccessCondition(List<String> splitInputs, VisitDate visitDate) {
        //given
        Orders orders = Orders.fromInput(splitInputs);
        Map<EventName, Integer> discountDetail = eventService.calculateDiscount(visitDate, orders);
        EventDetails eventDetails = EventDetails.from(discountDetail);
        //when
        int sumOfDiscount = eventDetails.findSumOfDiscount();
        //then
        assertThat(sumOfDiscount).isNotEqualTo(NO_DISCOUNT);
    }

    private static Stream<Arguments> sumOfOrderSuccessCondition() {
        return Stream.of(
                Arguments.of(List.of("타파스-10"), VisitDate.from(8)),
                Arguments.of(List.of("시저샐러드-10"), VisitDate.from(9)),
                Arguments.of(List.of("아이스크림-10"), VisitDate.from(22)),
                Arguments.of(List.of("양송이수프-10"), VisitDate.from(23))
        );
    }
}
