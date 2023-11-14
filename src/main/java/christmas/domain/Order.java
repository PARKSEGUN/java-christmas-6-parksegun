package christmas.model;

import static christmas.constants.OutputMessage.ORDER_FORMAT;

import christmas.constants.model.Menu;
import christmas.constants.model.MenuType;
import christmas.exception.InvalidOrderException;

/*
 *   주문에 대한 정보 담당
 * */

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

    public static Order of(String menuName, int count) {
        return new Order(Menu.fromName(menuName), count);
    }

    private void validateCount(int count) {
        if ((count < MIN_COUNT) || (count > MAX_COUNT)) {
            throw InvalidOrderException.exception;
        }
    }

    public boolean isCorrectMenuType(MenuType menuType) {
        return menu.getMenuType().equals(menuType);
    }

    public int findPrice() {
        return menu.getPrice() * count;
    }

    public MenuType findMenuType() {
        return menu.getMenuType();
    }

    public String findMenuName() {
        return menu.getName();
    }

    @Override
    public String toString() {
        return String.format(ORDER_FORMAT, menu.getName(), count);
    }

    public int getCount() {
        return count;
    }
}
