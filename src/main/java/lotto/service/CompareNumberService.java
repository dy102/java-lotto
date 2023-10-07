package lotto.service;

import java.util.List;

import static lotto.view.Output.*;

public class CompareNumberService {
    private final int[] equal = new int[5];
    public int isEqual(List<Integer> lottoNumber,
                       List<Integer> randomNumber){
        int sameNumber = 0;
        for(int i = 0; i < lottoNumber.size(); i++){
            if(randomNumber.contains(lottoNumber.get(i))){
                sameNumber++;
            }
        }
        return sameNumber;
    }
    public void makeResult(List<Integer> lottoNumber,
                      List<List<Integer>> randomNumberStorage,
                           int bonusNumber){
        for(int count = 0; count < randomNumberStorage.size(); count++){
            if(isEqual(lottoNumber, randomNumberStorage.get(count))==2){
                twoWin(randomNumberStorage, bonusNumber, count);
            }
            else if(isEqual(lottoNumber, randomNumberStorage.get(count))==3){
                threeWin(randomNumberStorage, bonusNumber, count);
            }
            else if(isEqual(lottoNumber, randomNumberStorage.get(count))==4){
                fourWin(randomNumberStorage, bonusNumber, count);
            }
            else if(isEqual(lottoNumber, randomNumberStorage.get(count))==5){
                fiveWin(randomNumberStorage, bonusNumber, count);
            }
            else if(isEqual(lottoNumber, randomNumberStorage.get(count))==6) {
                sixWin();
            }
        }
    }

    private void sixWin() {
        equal[4]++;
    }

    private void fiveWin(List<List<Integer>> randomNumberStorage, int bonusNumber, int count) {
        if(makeBonusResult(bonusNumber, randomNumberStorage.get(count))){
            equal[4]++;
        }
        else if(!makeBonusResult(bonusNumber, randomNumberStorage.get(count))){
            equal[2]++;
        }
    }

    private void fourWin(List<List<Integer>> randomNumberStorage, int bonusNumber, int count) {
        if(makeBonusResult(bonusNumber, randomNumberStorage.get(count))){
            equal[3]++;
        }
        else if(!makeBonusResult(bonusNumber, randomNumberStorage.get(count))){
            equal[1]++;
        }
    }

    private void threeWin(List<List<Integer>> randomNumberStorage, int bonusNumber, int count) {
        if(makeBonusResult(bonusNumber, randomNumberStorage.get(count))){
            equal[1]++;
        }
        else if(!makeBonusResult(bonusNumber, randomNumberStorage.get(count))){
            equal[0]++;
        }
    }

    private void twoWin(List<List<Integer>> randomNumberStorage, int bonusNumber, int i) {
        if(makeBonusResult(bonusNumber, randomNumberStorage.get(i))){
            equal[0]++;
        }
    }

    public boolean makeBonusResult(int bonusNumber,
                                List<Integer> randomNumber){
        if(randomNumber.contains(bonusNumber)){
            return true;
        }
        return false;
    }
    public void showResult(){
        String message = String.format(THREE_WIN.getMessage(), equal[0]);
        System.out.println(message);
        message = String.format(FOUR_WIN.getMessage(), equal[1]);
        System.out.println(message);
        message = String.format(FIVE_WIN.getMessage(), equal[2]);
        System.out.println(message);
        message = String.format(FIVE_WIN_BONUS.getMessage(), equal[3]);
        System.out.println(message);
        message = String.format(SIX_WIN.getMessage(), equal[4]);
        System.out.println(message);
    }

    public void showPercent(int money){
        double percent = ((double)(5000*equal[0] + 50000*equal[1]
                + 1500000*equal[2] + 30000000*equal[3]
                + 2000000000*equal[4])/(double)money)*100;
        String message = String.format(SHOW_PERCENT.getMessage(), percent);
        System.out.println(message);
    }
}
