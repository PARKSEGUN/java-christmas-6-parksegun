package christmas.model;

import static christmas.constants.InputConstants.DISTINGUISH_SIGN_TO_CHAR;

import christmas.constants.model.MenuType;
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
        validate(orders);

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


    public int countByMenuType(MenuType menuType) {
        return orders.stream()
                .filter(order -> order.isCorrectMenuType(menuType))
                .mapToInt(Order::getCount)
                .sum();
    }

    public int allPriceSum() {
        return orders.stream()
                .mapToInt(Order::findPrice)
                .sum();
    }

    ////////////////////////////////////////////////////////////////////////////////
    private void validate(List<Order> orders) {
        validateDuplicatedNames(orders);
        validateOrdersOnlyBeverage(orders);
        validateMenuCount(orders);
    }

    private void validateDuplicatedNames(List<Order> orders) {
        Set<String> duplicationChecker = new HashSet<>();
        List<String> ordersMenuName = orders.stream()
                .map(Order::findMenuName)
                .toList();
        for (String orderMenuName : ordersMenuName) {
            checkDuplicatedName(duplicationChecker, orderMenuName);
        }
    }

    private void checkDuplicatedName(Set<String> duplicationChecker, String orderMenuName) {
        if (duplicationChecker.add(orderMenuName)) {
            return;
        }
        throw InvalidOrderException.exception;
    }

    private void validateOrdersOnlyBeverage(List<Order> orders) {
        List<MenuType> menuTypes = orders.stream()
                .map((Order::findMenuType))
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Order order : orders) {
            stringBuilder.append(order).append("\n");
        }
        return stringBuilder.toString();
    }
}
