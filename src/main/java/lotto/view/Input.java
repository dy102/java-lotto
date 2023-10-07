package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int inputNumberAndCatch(){
        String number;
        while(true){
            number = Console.readLine();
            try{
                Integer.parseInt(number);
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 1000으로 나누어떨어지는 값을 입력하세요.");
                continue;
            }
            break;
        }
        return Integer.parseInt(number);
    }
    public int inputNumberAndThrow(){
        String number = Console.readLine();
        try{
            Integer.parseInt(number);
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(number);
    }
    public String inputString(){
        String number = Console.readLine();
        return number;
    }
}
