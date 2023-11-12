package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OrdersTest {

    private static final String FIX_COUNT = "-1";

    @ParameterizedTest
    @DisplayName("(음식-개수)에서 메뉴가 중복되었다면 예외 발생")
    @MethodSource
    void menusDuplicated(List<String> splitInputs) {
        //given
        List<String> newSplitInputs = splitInputs.stream()
                .map(splitInput -> splitInput + FIX_COUNT).toList();
        //when
        Throwable result = catchThrowable(() -> Orders.fromInput(newSplitInputs));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> menusDuplicated() {
        return Stream.of(
                Arguments.of(List.of("양송이수프", "양송이수프", "양송이수프")),
                Arguments.of(List.of("시저샐러드", "시저샐러드", "시저샐러드")),
                Arguments.of(List.of("해산물파스타", "해산물파스타", "해산물파스타")),
                Arguments.of(List.of("크리스마스파스타", "크리스마스파스타", "크리스마스파스타"))
        );
    }

    @ParameterizedTest
    @DisplayName("(음식-개수)에서 메뉴가 중복되지 않았다면 정상")
    @MethodSource
    void menusNotDuplicated(List<String> splitInputs) {
        //given
        List<String> newSplitInputs = splitInputs.stream()
                .map(splitInput -> splitInput + FIX_COUNT).toList();
        //when
        Throwable result = catchThrowable(() -> Orders.fromInput(newSplitInputs));
        //then
        assertThat(result).doesNotThrowAnyException();
    }

    private static Stream<Arguments> menusNotDuplicated() {
        return Stream.of(
                Arguments.of(List.of("양송이수프", "시저샐러드", "해산물파스타")),
                Arguments.of(List.of("시저샐러드", "해산물파스타", "크리스마스파스타")),
                Arguments.of(List.of("해산물파스타", "양송이수프", "크리스마스파스타")),
                Arguments.of(List.of("샴페인", "크리스마스파스타", "레드와인"))
        );
    }

    @ParameterizedTest
    @DisplayName("주문 총 개수가 20을 넘는다면 예외발생")
    @MethodSource
    void menusCountOverMax(List<String> splitInputs) {
        //given
        //when
        Throwable result = catchThrowable(() -> Orders.fromInput(splitInputs));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> menusCountOverMax() {
        return Stream.of(
                Arguments.of(List.of("양송이수프-10", "시저샐러드-20", "해산물파스타-30")),
                Arguments.of(List.of("양송이수프-10", "시저샐러드-10", "해산물파스타-10")),
                Arguments.of(List.of("양송이수프-20", "시저샐러드-1", "해산물파스타-1")),
                Arguments.of(List.of("양송이수프-5", "시저샐러드-15", "해산물파스타-1"))
        );
    }

    @ParameterizedTest
    @DisplayName("주문 총 개수가 20을 넘지 않는다면 정상")
    @MethodSource
    void menusCountDownMax(List<String> splitInputs) {
        //given
        //when
        Throwable result = catchThrowable(() -> Orders.fromInput(splitInputs));
        //then
        assertThat(result).doesNotThrowAnyException();
    }

    private static Stream<Arguments> menusCountDownMax() {
        return Stream.of(
                Arguments.of(List.of("양송이수프-1", "시저샐러드-2", "해산물파스타-3")),
                Arguments.of(List.of("양송이수프-1", "시저샐러드-1", "해산물파스타-1")),
                Arguments.of(List.of("양송이수프-18", "시저샐러드-1", "해산물파스타-1")),
                Arguments.of(List.of("양송이수프-5", "시저샐러드-5", "해산물파스타-1"))
        );
    }

    @ParameterizedTest
    @DisplayName("음료만 주문시 예외발생")
    @MethodSource
    void OrdersOnlyBeverage(List<String> splitInputs) {
        //given
        //when
        Throwable result = catchThrowable(() -> Orders.fromInput(splitInputs));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> OrdersOnlyBeverage() {
        return Stream.of(
                Arguments.of(List.of("제로콜라-1")),
                Arguments.of(List.of("제로콜라-1", "레드와인-2")),
                Arguments.of(List.of("제로콜라-1", "레드와인-2", "샴페인-3"))
        );
    }

    @ParameterizedTest
    @DisplayName("음료외에 다른 메뉴 있을시 정상")
    @MethodSource
    void OrdersNotOnlyBeverage(List<String> splitInputs) {
        //given
        //when
        Throwable result = catchThrowable(() -> Orders.fromInput(splitInputs));
        //then
        assertThat(result).doesNotThrowAnyException();
    }

    private static Stream<Arguments> OrdersNotOnlyBeverage() {
        return Stream.of(
                Arguments.of(List.of("제로콜라-1", "양송이수프-1")),
                Arguments.of(List.of("제로콜라-1", "레드와인-2", "해산물파스타-1")),
                Arguments.of(List.of("제로콜라-1", "레드와인-2", "샴페인-3", "크리스마스파스타-1"))
        );
    }
}
