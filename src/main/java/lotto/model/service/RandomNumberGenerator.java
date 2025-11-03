package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int LOTTO_MIN_NUMBER=1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    @Override
    public List<Integer> generate() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER,LOTTO_MAX_NUMBER,LOTTO_SIZE);
        List<Integer>lottosort= new ArrayList<>(lotto);
        lottosort.sort(Comparator.naturalOrder());

        return lottosort;
    }
}
