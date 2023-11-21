package christmas.model;

import static christmas.constants.InputConstants.DISTINGUISH_SIGN_TO_CHAR;

import christmas.constants.model.MenuType;
import christmas.exception.InvalidOrderException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 *   모든 주문의 정보르 담당
 * */

public class Orders {
    private static final int MAX_COUNT = 20;
    private final List<Order> orders;

    private Orders(List<Order> orders) {
        validate(orders);
        this.orders = orders;
    }

    public static Orders fromInput(List<String> splitInputs) {
        return new Orders(splitInputsToOrders(splitInputs));
    }

    private static List<Order> splitInputsToOrders(List<String> splitInputs) {
        List<Order> newOrders = new ArrayList<>();
        for (String splitInput : splitInputs) {
            String menuName = splitInput.substring(0, splitInput.indexOf(DISTINGUISH_SIGN_TO_CHAR));
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

    public int findSumOfPrice() {
        return orders.stream()
                .mapToInt(Order::findPrice)
                .sum();
    }

    private void validate(List<Order> orders) {
        validateDuplicatedNames(orders);
        validateOrdersOnlyBeverage(orders);
        validateMenuCount(orders);
    }

    private void validateDuplicatedNames(List<Order> orders) {
        Set<String> duplicationChecker = new HashSet<>();
        for (Order order : orders) {
            checkDuplicatedName(duplicationChecker, order.getMenuName());
        }
    }

    private void checkDuplicatedName(Set<String> duplicationChecker, String orderMenuName) {
        if (duplicationChecker.add(orderMenuName)) {
            return;
        }
        throw InvalidOrderException.exception;
    }

    private void validateOrdersOnlyBeverage(List<Order> orders) {
        for (Order order : orders) {
            if (order.isDifferentBeverage()) {
                return;
            }
        }
        throw InvalidOrderException.exception;
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
