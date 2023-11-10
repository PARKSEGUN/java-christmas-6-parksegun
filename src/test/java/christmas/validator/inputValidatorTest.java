package christmas.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class inputValidatorTest {


    @ParameterizedTest
    @DisplayName("입력이 숫자일 경우 정상")
    @MethodSource
    void inputCorrectNumber(String input) {
        //given
        //when
        Throwable result = catchThrowable(() -> InputValidator.notCorrectNumber(input));
        //then
        assertThat(result).doesNotThrowAnyException();
    }

    private static Stream<Arguments> inputCorrectNumber() {
        return Stream.of(
                Arguments.of("12345"),
                Arguments.of("1"),
                Arguments.of("0"),
                Arguments.of("11111"),
                Arguments.of("55555")
        );
    }

    @ParameterizedTest
    @DisplayName("입력이 숫자가 아니라면 예외 발생")
    @MethodSource
    void inputNotNumber(String input) {
        //given
        //when
        Throwable result = catchThrowable(() -> InputValidator.notCorrectNumber(input));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> inputNotNumber() {
        return Stream.of(
                Arguments.of("a"),
                Arguments.of("b"),
                Arguments.of("ㅁ"),
                Arguments.of("."),
                Arguments.of("-1")
        );
    }

    @ParameterizedTest
    @DisplayName("입력이 Int 형의 최대값을 넘길경우 예외 발생")
    @MethodSource
    void inputOverNumberValue(String input) {
        //given
        //when
        Throwable result = catchThrowable(() -> InputValidator.notCorrectNumber(input));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> inputOverNumberValue() {
        return Stream.of(
                Arguments.of("111111111111111111111111111"),
                Arguments.of("2222222222222222222222222"),
                Arguments.of("333333333333333333333333333"),
                Arguments.of("444444444444444444444444444"),
                Arguments.of("55555555555555555555")
        );
    }
}
