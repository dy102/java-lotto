package lotto.service;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.RandomNumber;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.Output.*;

public class InputNumberService {
    private final Input input;
    public InputNumberService(){
        input = new Input();
    }
    public int inputRandomNumber(){
        System.out.println(INPUT_MONEY.getMessage());
        return input.inputNumberAndCatch();
    }
    public List<Integer> inputLotto(){
        System.out.println(INPUT_LOTTO.getMessage());
        String[] number = input.inputString().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : number) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }
    public int inputBonus(){
        System.out.println(INPUT_BONUS.getMessage());
        return input.inputNumberAndThrow();
    }
}
