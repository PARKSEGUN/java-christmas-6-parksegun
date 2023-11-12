package christmas.domain;

import static christmas.constants.InputConstants.DISTINGUISH_SIGN_TO_CHAR;

import christmas.constants.domain.Menu;
import christmas.constants.domain.MenuType;
import christmas.exception.InvalidOrderException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Orders {
    private static final int BEGIN_INDEX = 0;
    private static final int MAX_COUNT = 20;
    private final List<Order> orders;

    private Orders(List<Order> orders) {
        validateMenuNames(orders);
        validateMenuCount(orders);
        this.orders = orders;
    }

    public static Orders fromInput(List<String> splitInputs) {
        return new Orders(inputToOrders(splitInputs));
    }

    private static List<Order> inputToOrders(List<String> splitInputs) {
        List<Order> newOrders = new ArrayList<>();
        for (String splitInput : splitInputs) {
            String menuName = splitInput.substring(BEGIN_INDEX, splitInput.indexOf(DISTINGUISH_SIGN_TO_CHAR));
            int menuCount = Integer.parseInt(splitInput.substring(splitInput.indexOf(DISTINGUISH_SIGN_TO_CHAR) + 1));
            newOrders.add(Order.of(menuName, menuCount));
        }
        return newOrders;
    }

    private void validateMenuNames(List<Order> orders) {
        validateDuplicatedNames(orders);
        validateOrdersOnlyBeverage(orders);
    }

    private void validateDuplicatedNames(List<Order> orders) {
        Set<String> duplicationChecker = new HashSet<>();
        List<String> ordersMenuName = orders.stream()
                .map(Order::getMenu)
                .map(Menu::getName)
                .toList();
        for (String orderMenuName : ordersMenuName) {
            if (isDuplicated(duplicationChecker, orderMenuName)) {
                throw InvalidOrderException.exception;
            }
        }
    }

    private boolean isDuplicated(Set<String> duplicationChecker, String orderMenuName) {
        if (duplicationChecker.add(orderMenuName)) {
            return false;
        }
        return true;
    }

    private void validateOrdersOnlyBeverage(List<Order> orders) {
        List<MenuType> menuTypes = orders.stream()
                .map((Order::getMenu))
                .map(Menu::getMenuType)
                .toList();
        if (isContainOnlyBeverage(menuTypes)) {
            throw InvalidOrderException.exception;
        }
    }

    private boolean isContainOnlyBeverage(List<MenuType> menuTypes) {
        int beverageCount = (int) menuTypes.stream()
                .filter(menuType -> menuType.equals(MenuType.BEVERAGE))
                .count();
        return menuTypes.size() == beverageCount;
    }


    private void validateMenuCount(List<Order> orders) {
        int countSum = orders.stream()
                .mapToInt(Order::getCount)
                .sum();
        if (countSum > MAX_COUNT) {
            throw InvalidOrderException.exception;
        }
    }

}