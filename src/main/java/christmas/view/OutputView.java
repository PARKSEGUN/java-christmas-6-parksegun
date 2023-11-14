package christmas.view;

import static christmas.constants.OutputMessage.EVENT_PREVIEW_MESSAGE_FORMAT;

import christmas.constants.ErrorMessage;
import christmas.constants.OutputMessage;
import christmas.model.VisitDate;
import java.util.List;

public class OutputView {
    private static final int eventPreviewTypeCount = 7;
    private static final List<String> eventPreviewTitle = List.of(
            "<주문 메뉴>", "<할인 전 총주문 금액>", "<증정 메뉴>", "<혜택 내역>", "<총혜택 금액>", "<할인 후 예상 결제 금액>", "<12월 이벤트 배지>"
    );

    public void printErrorMessage(ErrorMessage message) {
        System.out.println(message.getMessage());
    }

    public void printRequestMessage(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    public void printEventPreview(List<String> previewResultInfo) {
        for (int currentTypeCount = 0; currentTypeCount < eventPreviewTypeCount; currentTypeCount++) {
            System.out.println(eventPreviewTitle.get(currentTypeCount));
            System.out.println(previewResultInfo.get(currentTypeCount));
        }
    }

    public void printEventPreviewMessage(VisitDate visitDate) {
        System.out.println(String.format(EVENT_PREVIEW_MESSAGE_FORMAT.getMessage(), visitDate.getDate()));
    }
}
