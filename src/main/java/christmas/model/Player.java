package christmas.model;

import static christmas.constants.OutputMessage.PRICE_FORMAT;

import christmas.constants.model.EventBadge;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private final VisitDate visitDate;
    private final Orders orders;
    private final EventDetails eventDetails;

    private Player(VisitDate visitDate, Orders orders, EventDetails eventDetails) {
        this.visitDate = visitDate;
        this.orders = orders;
        this.eventDetails = eventDetails;
    }

    public static Player of(VisitDate visitDate, Orders orders, EventDetails eventDetails) {
        return new Player(visitDate, orders, eventDetails);
    }

    public int findAllDiscount() {
        return eventDetails.sumOfDiscounts();
    }

    public EventBadge findMatchingBadge() {
        return EventBadge.findMatchingBadge(findAllDiscount());
    }

    public List<String> createPreviewInfoOutput() {
        List<String> previewInfo = new ArrayList<>();
        DecimalFormat decimalFormat = new DecimalFormat();
        addPreviewInfoMessage(previewInfo, decimalFormat);
        return previewInfo;
    }

    private void addPreviewInfoMessage(List<String> previewInfo, DecimalFormat decimalFormat) {
        int allOrdersPrice = orders.allPriceSum();
        int allDiscount = eventDetails.sumOfDiscounts();
        previewInfo.add(orders.toString());
        previewInfo.add(String.format(PRICE_FORMAT.getMessage(), decimalFormat.format(allOrdersPrice)) + "\n");
        previewInfo.add(eventDetails.toStringGiftEvent() + "\n");
        previewInfo.add(eventDetails.toStringDiscountInfo());
        previewInfo.add(String.format(PRICE_FORMAT.getMessage(), decimalFormat.format(-allDiscount)) + "\n");
        previewInfo.add(
                String.format(PRICE_FORMAT.getMessage(), decimalFormat.format(allOrdersPrice - allDiscount)) + "\n");
        previewInfo.add(findMatchingBadge().getName());
    }
}
