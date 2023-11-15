<<<<<<< HEAD
package christmas.validator;
=======
package christmas.view;
>>>>>>> parksegun

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

<<<<<<< HEAD
import java.util.stream.Stream;
=======
import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
>>>>>>> parksegun
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

<<<<<<< HEAD
public class inputValidatorTest {

=======
public class inputTest {

    private final InputView inputView = new InputView();

    @AfterEach
    void tearDown() {
        Console.close();
    }

    public InputStream createInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
>>>>>>> parksegun

    @ParameterizedTest
    @DisplayName("입력이 숫자일 경우 정상")
    @MethodSource
    void inputCorrectNumber(String input) {
        //given
<<<<<<< HEAD
        //when
        Throwable result = catchThrowable(() -> InputValidator.notCorrectNumber(input));
=======
        System.setIn(createInput(input));
        //when
        Throwable result = catchThrowable(inputView::readVisitDate);
>>>>>>> parksegun
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
<<<<<<< HEAD
        //when
        Throwable result = catchThrowable(() -> InputValidator.notCorrectNumber(input));
=======
        System.setIn(createInput(input));
        //when
        Throwable result = catchThrowable(inputView::readVisitDate);
>>>>>>> parksegun
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> inputNotNumber() {
        return Stream.of(
                Arguments.of("a"),
                Arguments.of("b"),
                Arguments.of("ㅁ"),
<<<<<<< HEAD
                Arguments.of("."),
                Arguments.of("-1")
=======
                Arguments.of(".")
>>>>>>> parksegun
        );
    }

    @ParameterizedTest
    @DisplayName("입력이 Int 형의 최대값을 넘길경우 예외 발생")
    @MethodSource
    void inputOverNumberValue(String input) {
        //given
<<<<<<< HEAD
        //when
        Throwable result = catchThrowable(() -> InputValidator.notCorrectNumber(input));
=======
        System.setIn(createInput(input));
        //when
        Throwable result = catchThrowable(inputView::readVisitDate);
>>>>>>> parksegun
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

<<<<<<< HEAD
//    @ParameterizedTest
//    @DisplayName("(comma)를 기준으로 자른 문자열이 비어있을때 예외 발생")
//    @MethodSource
//    void splitInputIsEmpty(String input) {
//        //given
//        //when
//        Throwable result = catchThrowable(() -> InputValidator.splitInputEmpty(input));
//        //then
//        assertThat(result).isInstanceOf(IllegalArgumentException.class);
//    }

//    private static Stream<Arguments> splitInputIsEmpty() {
//        return Stream.of(
//                Arguments.of("1,,2"),
//                Arguments.of("1,2,3,,4"),
//                Arguments.of("1,2,,3"),
//                Arguments.of("1,,,,,5")
//        );
//    }
//
//    @ParameterizedTest
//    @DisplayName("(comma)를 기준으로 자른 문자열이 비어있지 않다면 정상")
//    @MethodSource
//    void splitInputIsNotEmpty(String input) {
//        //given
//        //when
//        Throwable result = catchThrowable(() -> InputValidator.splitInputEmpty(input));
//        //then
//        assertThat(result).doesNotThrowAnyException();
//    }
//
//    private static Stream<Arguments> splitInputIsNotEmpty() {
//        return Stream.of(
//                Arguments.of("1,2,3"),
//                Arguments.of("1,2,3,4,5"),
//                Arguments.of("1,2,3,4"),
//                Arguments.of("1,2,3,4,5")
//        );
//    }

=======
>>>>>>> parksegun
    @ParameterizedTest
    @DisplayName("(comma)로 나눠진 값이 정규식을 따르지 않는다면 예외 발생")
    @MethodSource
    void distinguishSignCountIsNotOne(String input) {
        //given
<<<<<<< HEAD
        //when
        Throwable result = catchThrowable(() -> InputValidator.notOneCountDistinguishSign(input));
=======
        System.setIn(createInput(input));
        //when
        Throwable result = catchThrowable(inputView::readOrders);
>>>>>>> parksegun
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> distinguishSignCountIsNotOne() {
        return Stream.of(
                Arguments.of("가--3"),
                Arguments.of("-가-3"),
                Arguments.of("5-5"),
                Arguments.of("A-5")
        );
    }

    @ParameterizedTest
    @DisplayName("(comma)로 나눠진 값이 정규식을 따른다면 정상")
    @MethodSource
    void distinguishSignCountIsOne(String input) {
        //given
<<<<<<< HEAD
        //when
        Throwable result = catchThrowable(() -> InputValidator.notOneCountDistinguishSign(input));
=======
        System.setIn(createInput(input));
        //when
        Throwable result = catchThrowable(inputView::readOrders);
>>>>>>> parksegun
        //then
        assertThat(result).doesNotThrowAnyException();
    }

    private static Stream<Arguments> distinguishSignCountIsOne() {
        return Stream.of(
                Arguments.of("가-1"),
                Arguments.of("나-1"),
                Arguments.of("다-5"),
                Arguments.of("파스타-5")
        );
    }
<<<<<<< HEAD
=======

    @ParameterizedTest
    @DisplayName("마지막 입력문자가 (comma)일때 예외 발생")
    @MethodSource
    void endOfInputWordIsComma(String input) {
        //given
        System.setIn(createInput(input));
        //when
        Throwable result = catchThrowable(inputView::readOrders);
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> endOfInputWordIsComma() {
        return Stream.of(
                Arguments.of("가-3,"),
                Arguments.of("가-3,,"),
                Arguments.of("가-3,가-3,,"),
                Arguments.of("가-3,가-3,가-3,")
        );
    }

>>>>>>> parksegun
}
