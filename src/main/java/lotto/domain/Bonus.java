package lotto.domain;

public class Bonus {
    private int bonusNumber = 0;

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Bonus(int number){
        validate(number);
        this.bonusNumber = number;
    }

    public void validate(int number){
        if(Integer.toString(number).length()!=1){
            throw new IllegalArgumentException();
        }
    }

}
