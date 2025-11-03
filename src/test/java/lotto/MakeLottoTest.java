//package lotto.service;
package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.service.MakeLotto;
import lotto.model.service.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import lotto.model.service.FixedNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MakeLottoTest {

    private MakeLotto makeLotto;
    private final List<List<Integer>> fixedTestNumbers = List.of(
            List.of(1, 2, 3, 4, 5, 6),
            List.of(7, 8, 9, 10, 11, 12)
    );
    private final int lottoCount = 2;

    @DisplayName("1. countLotto: 입력된 금액을 1000으로 나누어 구매 개수를 정확히 계산해야 한다.")
    @Test
    void countLotto_ShouldCalculateCorrectCount() {
        int price = 8000;
        int count = makeLotto.countLotto(price);
        assertThat(count).isEqualTo(8);
    }

    @DisplayName("2. makeLotto: 요청된 개수만큼 생성하며, 각 로또는 6개 번호로 정렬되어야 한다.")
    @Test
    void makeLotto_ShouldReturnCorrectSizeAndSortedNumbers() {
        List<List<Integer>> lottos = fixedTestNumbers;
        assertThat(lottos).hasSize(lottoCount);

        for (List<Integer> lotto : lottos) {
            assertThat(lotto).hasSize(6);
            assertThat(lotto).isSorted();
        }
    }
}

