package lotto.controller;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.RandomNumber;
import lotto.service.CompareNumberService;
import lotto.service.InputNumberService;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.List;


public class LottoController {
    //전부다 받아와서. inputNumberService의 메서드를 사용해서 input하는 방법
    //인스턴스 생성은 모두 Controller에서 진행한다.
    private final Bonus bonus;
    private final Lotto lotto;
    private final RandomNumber randomNumber;
    private final InputNumberService inputNumberService;
    private final CompareNumberService compareNumberService;

    public LottoController(){
        inputNumberService = new InputNumberService();
        compareNumberService = new CompareNumberService();

        randomNumber = new RandomNumber(inputNumberService.inputRandomNumber());
        randomNumber.showStatus();

        lotto = new Lotto(inputNumberService.inputLotto());
        bonus = new Bonus(inputNumberService.inputBonus());
    }
    public void program(){
        compareNumberService.makeResult(lotto.getNumbers(),
                randomNumber.getNumbersStorage(),bonus.getBonusNumber());
        compareNumberService.showResult();
        compareNumberService.showPercent(randomNumber.getCount()*1000);
    }
}
