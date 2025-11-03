package lotto.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.domain.Rank;

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
