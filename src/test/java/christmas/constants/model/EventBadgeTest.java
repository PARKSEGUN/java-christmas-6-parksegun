package christmas.constants.model;

import static christmas.constants.model.EventBadge.NONE;
import static christmas.constants.model.EventBadge.SANTA;
import static christmas.constants.model.EventBadge.STAR;
import static christmas.constants.model.EventBadge.TREE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EventBadgeTest {

    @ParameterizedTest
    @DisplayName("어떤 배지가 적용되는지 확인한다.")
    @MethodSource
    void findMatchingEventBadge(int allDiscount, EventBadge expectResult) {
        //given
        //when
        EventBadge result = EventBadge.findMatchingBadge(allDiscount);
        //then
        assertThat(result).isEqualTo(expectResult);
    }

    private static Stream<Arguments> findMatchingEventBadge() {
        return Stream.of(
                Arguments.of(2000, NONE),
                Arguments.of(7000, STAR),
                Arguments.of(12000, TREE),
                Arguments.of(17000, TREE),
                Arguments.of(20000, SANTA),
                Arguments.of(30000, SANTA)
        );
    }
}
