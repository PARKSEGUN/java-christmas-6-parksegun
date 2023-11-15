<<<<<<< HEAD
package christmas.domain;
=======
package christmas.model;
>>>>>>> parksegun

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class VisitDateTest {

    @ParameterizedTest
    @DisplayName("입력이 1 ~ 31 사이 값이라면 정상")
    @MethodSource
    void visitDateInRange(int date) {
        //given
        //when
        Throwable result = catchThrowable(() -> VisitDate.from(date));
        //then
        assertThat(result).doesNotThrowAnyException();
    }

    private static Stream<Arguments> visitDateInRange() {
        return Stream.of(
                Arguments.of(5),
                Arguments.of(15),
                Arguments.of(25)
        );
    }

    @ParameterizedTest
    @DisplayName("입력이 1 ~ 31 사이 값이 아니라면 예외 발생")
    @MethodSource
    void visitDateOutRange(int date) {
        //given
        //when
        Throwable result = catchThrowable(() -> VisitDate.from(date));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> visitDateOutRange() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(32)
        );
    }


}
