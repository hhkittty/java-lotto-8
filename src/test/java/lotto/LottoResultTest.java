package lotto;

import lotto.model.domain.WinningNumbers;
import lotto.model.service.LottoResult;
import lotto.model.service.RankCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.model.domain.Rank.FIVE;
import static lotto.model.domain.Rank.FIVE_BONUS;
import static lotto.model.domain.Rank.NONE;
import static lotto.model.domain.Rank.SIX;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private static final List<Integer> winNums=List.of(1,2,3,4,5,6);
    private static final int bonusNum=7;
    private final WinningNumbers winningNumbers=new WinningNumbers(winNums,bonusNum);
    private LottoResult result;
    private RankCalculator rankCalculator;

    @BeforeEach
    void setUp() {
       rankCalculator=new RankCalculator();
       result=new LottoResult(rankCalculator);
    }

    @Test
    @DisplayName("LottoResultTest")
    void lottoResultTest() {
        List<List<Integer>> purchasedLottos = List.of(
                List.of(1, 2, 3, 4, 5, 6),   //SIX
                List.of(1, 2, 3, 4, 5, 7),    // FIVE_BONUS
                List.of(1, 2, 3, 4, 5, 8),    //FIVE
                List.of(7, 8, 9, 10, 11, 12)); // NONE

        List<Integer> counts = result.calculateRank(winningNumbers,purchasedLottos);

        assertThat(counts.get(SIX.ordinal())).isEqualTo(1);
        assertThat(counts.get(FIVE_BONUS.ordinal())).isEqualTo(1);
        assertThat(counts.get(FIVE.ordinal())).isEqualTo(1);
        assertThat(counts.get(NONE.ordinal())).isEqualTo(1);
    }

    @Test
    @DisplayName("totalPrizeTest")
    void totalPrizeTest() {
        List<Integer> rankCounts=List.of(2,3,0,1,0,1);
        int expectedTotal=30160000;
        int actualtotal=result.totalPrize(rankCounts);
        assertThat(actualtotal).isEqualTo(expectedTotal);
    }

    @DisplayName("pnlTest")
    @ParameterizedTest()
    @CsvSource({
            "5000, 8000, 62.50",
            "20000, 10000, 200.00",
            "0, 5000, 0.00",
            "5000, 14000, 35.71",
            "7143, 10000, 71.43"
    })
    void pnlTest(int totalPrice, int inputPrice, double expectedPnl) {
        double actualPnl = result.pnl(totalPrice, inputPrice);
        assertThat(actualPnl).isEqualTo(expectedPnl);
    }
}

