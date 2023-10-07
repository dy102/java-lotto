package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.RandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest{
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액에 맞게 로또 개수를 발행한다.")
    @Test
    void createRandomLotto(){
        RandomNumber randomNumber = new RandomNumber(8000);
        //클래스 이름을 Random으로 설정해버리니까 계속 Random API를 불러와서 귀찮아지네
        //있을 것 같은 API로는 클래스이름을 설정하지 않는 것이 좋겠다.
        randomNumber.showStatus();
        assertThat(output()).contains("개 구매했습니다.");

    }
    @DisplayName("보너스 값을 입력 받을 때 한 자리의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusByOverSize(){
        assertThatThrownBy(() -> new Bonus(10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {

    }
    // 아래에 추가 테스트 작성 가능
}
