package christmas.view;

import static christmas.constants.OutputMessage.ALL_DISCOUNT_PRICE_MESSAGE;
import static christmas.constants.OutputMessage.ALL_ORDER_PRICE_MESSAGE;
import static christmas.constants.OutputMessage.DISCOUNT_DETAIL_MESSAGE;
import static christmas.constants.OutputMessage.EVENT_BADGE_MESSAGE;
import static christmas.constants.OutputMessage.EVENT_PREVIEW_MESSAGE_FORMAT;
import static christmas.constants.OutputMessage.EXPECTED_PAYMENT_MESSAGE;
import static christmas.constants.OutputMessage.GIFT_MENU_MESSAGE;
import static christmas.constants.OutputMessage.MONEY_FORMAT;
import static christmas.constants.OutputMessage.ORDER_MENU_MESSAGE;

import christmas.constants.ErrorMessage;
import christmas.constants.OutputMessage;
import christmas.constants.model.EventBadge;
import christmas.model.EventDetails;
import christmas.model.Orders;
import christmas.model.VisitDate;
import java.text.DecimalFormat;

/*
 *   출력 담당
 * */

public class OutputView {

    public void printErrorMessage(ErrorMessage message) {
        System.out.println(message.getMessage());
    }

    public void printOutputMessage(OutputMessage message) {
        System.out.println(message.getMessage());
    }

<<<<<<< HEAD
    //얘 위치 다시 생각
    private String convertToMoneyFormat(int money) {
        DecimalFormat decimalFormat = new DecimalFormat();
        return String.format(MONEY_FORMAT, decimalFormat.format(money));
    }


=======
>>>>>>> parksegun
    public void printEventPreview(VisitDate visitDate, Orders orders, EventDetails eventDetails) {
        int allOrdersPrice = orders.findSumOfPrice();
        int allDiscount = eventDetails.findSumOfDiscount();
        printEventPreviewMessage(visitDate);
        printOrderMenu(orders);
        printAllOrderPrice(allOrdersPrice);
        printGiftMenu(eventDetails);
        printDiscountDetail(eventDetails);
        printAllDiscountPrice(allDiscount);
        printExpectedPayment(allOrdersPrice - allDiscount);
        printEventBadge(eventDetails.findEventBadge());
    }

    private void printEventPreviewMessage(VisitDate visitDate) {
        System.out.println(String.format(EVENT_PREVIEW_MESSAGE_FORMAT, visitDate.getDate()));
    }

    private void printOrderMenu(Orders orders) {
        printOutputMessage(ORDER_MENU_MESSAGE);
<<<<<<< HEAD
        System.out.println(orders.toString());
=======
        System.out.println(orders);
>>>>>>> parksegun
    }

    private void printAllOrderPrice(int allOrdersPrice) {
        printOutputMessage(ALL_ORDER_PRICE_MESSAGE);
        System.out.println(convertToMoneyFormat(allOrdersPrice));
    }

    private void printGiftMenu(EventDetails eventDetails) {
        printOutputMessage(GIFT_MENU_MESSAGE);
        System.out.println(eventDetails.toStringGiftEvent());
    }

    private void printDiscountDetail(EventDetails eventDetails) {
        printOutputMessage(DISCOUNT_DETAIL_MESSAGE);
<<<<<<< HEAD
        System.out.println(eventDetails.toStringDiscountInfo());
=======
        System.out.println(eventDetails);
>>>>>>> parksegun
    }

    private void printAllDiscountPrice(int allDiscount) {
        printOutputMessage(ALL_DISCOUNT_PRICE_MESSAGE);
        System.out.println(convertToMoneyFormat(-allDiscount));
    }


    private void printExpectedPayment(int expectedPayment) {
        printOutputMessage(EXPECTED_PAYMENT_MESSAGE);
        System.out.println(convertToMoneyFormat(expectedPayment));
    }

    private void printEventBadge(EventBadge eventBadge) {
        printOutputMessage(EVENT_BADGE_MESSAGE);
<<<<<<< HEAD
        System.out.println(eventBadge.getName());
=======
        System.out.println(eventBadge);
    }

    private String convertToMoneyFormat(int money) {
        DecimalFormat decimalFormat = new DecimalFormat();
        return String.format(MONEY_FORMAT, decimalFormat.format(money));
>>>>>>> parksegun
    }
}
