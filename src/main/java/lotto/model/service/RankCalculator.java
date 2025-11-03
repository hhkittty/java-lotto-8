package lotto.model.service;

import java.util.List;

public class RankCalculator {
    public int countSame(List<Integer> lottoNumber,List<Integer> randomnum) {
        int countSame = 0;
        for (int i : randomnum) {
            if (lottoNumber.contains(i)) {
                countSame++;
            }
        }
        return countSame;
    }

    public boolean checkBonus(int bonus, List<Integer> randomnum) {
        return randomnum.contains(bonus);
    }


}
