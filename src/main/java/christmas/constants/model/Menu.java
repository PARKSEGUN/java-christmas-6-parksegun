package christmas.constants.model;

import static christmas.constants.model.MenuType.APPETIZER;
import static christmas.constants.model.MenuType.BEVERAGE;
import static christmas.constants.model.MenuType.DESSERT;
import static christmas.constants.model.MenuType.MAIN;

import christmas.exception.InvalidOrderException;

/*
 *   메뉴에 대한 상수 정보 담당
 * */

public enum Menu {

    MUSHROOM_SOUP("양송이수프", 6_000, APPETIZER),
    TAPAS("타파스", 5_500, APPETIZER),
    CAESAR_SALAD("시저샐러드", 8_000, APPETIZER),
    T_BONE_STEAK("티본스테이크", 55_000, MAIN),
    BARBECUE_RIBS("바비큐립", 54_000, MAIN),
    SEAFOOD_PASTA("해산물파스타", 35_000, MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, MAIN),
    CHOCOLATE_CAKE("초코케이크", 15_000, DESSERT),
    ICE_CREAM("아이스크림", 5_000, DESSERT),
    ZERO_COLA("제로콜라", 3_000, BEVERAGE),
    RED_WINE("레드와인", 60_000, BEVERAGE),
    CHAMPAGNE("샴페인", 25_000, BEVERAGE);

    private final String name;
    private final int price;
    private final MenuType menuType;

    Menu(String name, int price, MenuType menuType) {
        this.name = name;
        this.price = price;
        this.menuType = menuType;
    }

    public static Menu fromName(String inputName) {
        return validate(inputName);
    }

    private static Menu validate(String inputName) {
        for (Menu menu : values()) {
            if (menu.name.equals(inputName)) {
                return menu;
            }
        }
        throw InvalidOrderException.exception;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuType getMenuType() {
        return menuType;
    }
}
