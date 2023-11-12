package christmas.constants.model;

public enum EventBadge {
    NONE("없음", 0),
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);


    private final String name;
    private final int priceCondition;

    EventBadge(String name, int priceCondition) {
        this.name = name;
        this.priceCondition = priceCondition;
    }

    public static EventBadge findMatchingBadge(int allDiscount) {
        if (allDiscount >= SANTA.priceCondition) {
            return SANTA;
        }
        if (allDiscount >= TREE.priceCondition) {
            return TREE;
        }
        if (allDiscount >= STAR.priceCondition) {
            return STAR;
        }
        return NONE;
    }
}
