package christmas.constants.model;

/*
 *   메뉴 종류에 대한 상수 정보 담당
 * */

public enum MenuType {

    APPETIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    BEVERAGE("음료");

    private final String value;

    MenuType(String value) {
        this.value = value;
    }
}
