package christmas.model;

import christmas.constants.model.Menu;
import christmas.constants.model.MenuType;
import christmas.exception.InvalidOrderException;

public class Order {
    private static final int MIN_COUNT = 1;
    private static final int MAX_COUNT = 20;

    private final Menu menu;

    private final int count;

    private Order(Menu menu, int count) {
        validateCount(count);
        this.menu = menu;
        this.count = count;
    }

    public static final Order of(String menuName, int count) {
        return new Order(Menu.fromName(menuName), count);
    }

    private void validateCount(int count) {
        if ((count < MIN_COUNT) || (count > MAX_COUNT)) {
            throw InvalidOrderException.exception;
        }
    }

    public boolean isDessertMenu() {
        return menu.getMenuType() == MenuType.DESSERT;
    }

    public boolean isMainMenu() {
        return menu.getMenuType() == MenuType.MAIN;
    }

    public int price() {
        return menu.getPrice() * count;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }
}
