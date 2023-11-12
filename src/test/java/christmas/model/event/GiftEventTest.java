package christmas.model.event;

import static christmas.constants.model.EventConstants.NO_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.Orders;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GiftEventTest {
    private static final int GIFT_PRICE = 25_000;
    private final GiftEvent giftEvent = new GiftEvent();

    @ParameterizedTest
    @DisplayName("총 주문 금액이 12만원 넘는다면 할인 적용")
    @MethodSource
    void allOrdersPriceOverGiftCondition(List<String> splitInputs) {
        //given
        Orders orders = Orders.fromInput(splitInputs);

        //when
        int result = giftEvent.findDiscount(orders);
        //then
        assertThat(result).isEqualTo(GIFT_PRICE);
    }

    private static Stream<Arguments> allOrdersPriceOverGiftCondition() {
        return Stream.of(
                Arguments.of(List.of("크리스마스파스타-5")),
                Arguments.of(List.of("티본스테이크-2", "시저샐러드-2")),
                Arguments.of(List.of("티본스테이크-1", "크리스마스파스타-2", "초코케이크-1")),
                Arguments.of(List.of("양송이수프-20"))
        );
    }

    @ParameterizedTest
    @DisplayName("총 주문 금액이 12만원 넘지 않는다면 할인은 없다.")
    @MethodSource
    void allOrdersPriceNotOverGiftCondition(List<String> splitInputs) {
        //given
        Orders orders = Orders.fromInput(splitInputs);
        //when
        int result = giftEvent.findDiscount(orders);
        //then
        assertThat(result).isEqualTo(NO_DISCOUNT);
    }

    private static Stream<Arguments> allOrdersPriceNotOverGiftCondition() {
        return Stream.of(
                Arguments.of(List.of("크리스마스파스타-4")),
                Arguments.of(List.of("티본스테이크-2", "시저샐러드-1")),
                Arguments.of(List.of("티본스테이크-1", "크리스마스파스타-1", "초코케이크-1")),
                Arguments.of(List.of("양송이수프-19"))
        );
    }
}
