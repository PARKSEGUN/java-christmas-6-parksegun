package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OrderTest {
    private static final int FIX_COUNT = 1;
    private static final String FIX_NAME = "타파스";

    @ParameterizedTest
    @DisplayName("(음식-개수)에서 음식이 메뉴에 포함되어있지 않다면 예외 발생")
    @MethodSource
    void notMatchMenu(String menuName, int menuCount) {
        //given
        //when
        Throwable result = catchThrowable(() -> Order.of(menuName, menuCount));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> notMatchMenu() {
        return Stream.of(
                Arguments.of("name", FIX_COUNT),
                Arguments.of("제로사이다", FIX_COUNT),
                Arguments.of("바나나케이크", FIX_COUNT),
                Arguments.of("화이트와인", FIX_COUNT)
        );
    }

    @ParameterizedTest
    @DisplayName("(음식-개수)에서 음식이 메뉴에 포함되어있다면 정상")
    @MethodSource
    void matchMenu(String menuName, int menuCount) {
        //given
        //when
        Throwable result = catchThrowable(() -> Order.of(menuName, menuCount));
        //then
        assertThat(result).doesNotThrowAnyException();
    }

    private static Stream<Arguments> matchMenu() {
        return Stream.of(
                Arguments.of("양송이수프", FIX_COUNT),
                Arguments.of("타파스", FIX_COUNT),
                Arguments.of("시저샐러드", FIX_COUNT),
                Arguments.of("아이스크림", FIX_COUNT)
        );
    }

    @ParameterizedTest
    @DisplayName("(음식-개수)에서 개수가 1 ~ 20 사이의 값이 아니라면 예외 발생")
    @MethodSource
    void menuCountOutRange(String menuName, int menuCount) {
        //given
        //when
        Throwable result = catchThrowable(() -> Order.of(menuName, menuCount));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> menuCountOutRange() {
        return Stream.of(
                Arguments.of(FIX_NAME, 0),
                Arguments.of(FIX_NAME, 21),
                Arguments.of(FIX_NAME, 22),
                Arguments.of(FIX_NAME, 25)
        );
    }

    @ParameterizedTest
    @DisplayName("(음식-개수)에서 개수가 1 ~ 20 사이의 값이라면 정상")
    @MethodSource
    void menuCountInRange(String menuName, int menuCount) {
        //given
        //when
        Throwable result = catchThrowable(() -> Order.of(menuName, menuCount));
        //then
        assertThat(result).doesNotThrowAnyException();
    }

    private static Stream<Arguments> menuCountInRange() {
        return Stream.of(
                Arguments.of(FIX_NAME, 1),
                Arguments.of(FIX_NAME, 5),
                Arguments.of(FIX_NAME, 15),
                Arguments.of(FIX_NAME, 20)
        );
    }
}
