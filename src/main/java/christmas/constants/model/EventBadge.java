package christmas.constants.model;

import java.util.Arrays;

public enum EventBadge {

    SANTA("산타", 20_000),

    TREE("트리", 10_000),

    STAR("별", 5_000),
    NONE("없음", 0);
    private final String name;
    private final int priceCondition;

    EventBadge(String name, int priceCondition) {
        this.name = name;
        this.priceCondition = priceCondition;
    }

    public static EventBadge findMatchingBadge(int allDiscount) {
        for (EventBadge currentEventBadge : Arrays.stream(values()).toList()) {
            if (allDiscount >= currentEventBadge.priceCondition) {
                return currentEventBadge;
            }
        }
        throw new IllegalArgumentException("할인의 합이 0보다 작은값은 될 수 없습니다");
    }

    public String getName() {
        return name;
    }
}
