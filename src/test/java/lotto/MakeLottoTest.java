package lotto;


import java.util.List;
import lotto.model.service.MakeLotto;
import lotto.model.service.FixedNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MakeLottoTest {

    private MakeLotto makeLotto;
    private final List<List<Integer>> fixedTestNumbers = List.of(
            List.of(1, 2, 3, 4, 5, 6),
            List.of(7, 8, 9, 10, 11, 12),
            List.of(6 ,5, 4, 3, 2, 1)
    );
    private final int lottoCount = 3;

    @DisplayName("countLotto: 입력된 금액을 1000으로 나누어 구매 개수를 정확히 계산해야 한다.")
    @Test
    void countLotto_ShouldCalculateCorrectCount() {
        int price = 8000;
        int count = makeLotto.countLotto(price);
        assertThat(count).isEqualTo(8);
    }

    @DisplayName("makeLotto: 요청된 개수만큼 생성하며, 각 로또는 6개 번호로 정렬되어야 한다.")
    @Test
    void makeLotto_ShouldReturnCorrectSizeAndSortedNumbers() {

        List<List<Integer>> lottos = fixedTestNumbers;
        FixedNumberGenerator fixedNumber=new FixedNumberGenerator(lottos);
        assertThat(lottos).hasSize(lottoCount);

        for (int i=0;i<lottoCount;i++) {
            List<Integer> lotto= fixedNumber.generate();
            assertThat(lotto).hasSize(6);
            assertThat(lotto).isSorted();
        }
    }

}

