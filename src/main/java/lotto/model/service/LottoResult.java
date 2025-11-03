package lotto.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.domain.Rank;
import lotto.model.domain.WinningNumbers;

public class LottoResult {
    private final RankCalculator calculator;

    public LottoResult(RankCalculator rankCalculator) {
        this.calculator = rankCalculator;
    }

    public List<Integer> calculateRank(WinningNumbers winning, List<List<Integer>> RandomLottos) {
        List<Integer> rankCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
        List<Integer> winNums = winning.getWinningNumbers();
        int bonusNum = winning.getBonusNumber();

        for (List<Integer> lotto : RandomLottos) {
            int countSame = calculator.countSame(winNums,lotto);
            boolean checkBonus = calculator.checkBonus(bonusNum, lotto);

            Rank rank = Rank.findRank(countSame, checkBonus);
            rankCount.set(rank.ordinal(), rankCount.get(rank.ordinal()) + 1);
        }
        return rankCount;
    }

    public int totalPrize(List<Integer> totalCountCorrect){
        int sum=0;
        Rank[] ranks=Rank.values();
        for(int i=0;i<ranks.length;i++){
            sum+=ranks[i].getPrize()*totalCountCorrect.get(i);
        }
        return sum;
    }
    public double pnl(int totalPrice,int inputPrice){
        double pnl = totalPrice/(double)inputPrice*100;
        pnl=Math.round(pnl*100.0)/100.0;
        return pnl;
    }
}
