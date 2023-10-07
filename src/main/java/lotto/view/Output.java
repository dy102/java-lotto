package lotto.view;

public enum Output {
    PERCENT(""),
    SAME(""),
    SHOW_LOTTO_NUMBER(""),
    BUY_LOTTO("개를 구매했습니다."),
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_LOTTO("당첨 번호를 입력해 주세요."),
    INPUT_BONUS("보너스 번호를 입력해 주세요."),
    SHOW_PERCENT("총 수익률은 %.1f%%입니다."),
    THREE_WIN("3개 일치 (5,000원) - %d개"),
    FOUR_WIN("4개 일치 (50,000원) - %d개"),
    FIVE_WIN("5개 일치 (1,500,000원) - %d개"),
    FIVE_WIN_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_WIN("6개 일치 (2,000,000,000원) - %d개");

    private final String message;

    private Output(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
