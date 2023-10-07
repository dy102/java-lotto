package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumber {
    private List<List<Integer>> numbersStorage = new ArrayList<>();

    public List<List<Integer>> getNumbersStorage() {
        return numbersStorage;
    }

    private List<Integer> numbers;
    private int count = 0;

    public int getCount() {
        return count;
    }

    public RandomNumber(int money){
        if((double)money%1000!=0){
            throw new IllegalArgumentException();
        }
        int count = money/1000;
        this.count = count;
        while(numbersStorage.size()<count){
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); // 인스턴스 생성에 대해 궁금한 게 있음.
            checkDuplication(numbers);
        }
    }
    public void checkDuplication(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size()!=numbers.size()){
            return;
        }
        numbersStorage.add(numbers);
    }
    public void showStatus(){
        System.out.println(this.count + "개를 구매했습니다.");
        for (List<Integer> integers : numbersStorage) {
            System.out.println(integers);
        }
    }
}
