package lotto.domain;

import java.util.List;
public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < numbers.size(); i++){
            int box = numbers.get(i);
            numbers.set(i,0);
            if(numbers.contains(box)){
                throw new IllegalArgumentException();
            }
            numbers.set(i,box);
        }
    }

    // TODO: 추가 기능 구현
}
