package christmas.model;

import static christmas.constants.OutputMessage.ORDER_FORMAT;
import static christmas.constants.model.MenuType.BEVERAGE;

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

    public boolean isDifferentBeverage() {
        if (menu.getMenuType().equals(BEVERAGE)) {
            return false;
        }
        return true;
    }

    public int findPrice() {
        return menu.getPrice() * count;
    }

    @Override
    public String toString() {
        return String.format(ORDER_FORMAT, menu.getName(), count);
    }

    public String getMenuName() {
        return menu.getName();
    }

    public int getCount() {
        return count;
    }
}
