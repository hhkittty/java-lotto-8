package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.model.domain.Lotto;

public class MakeLotto {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private final NumberGenerator generator;

    public MakeLotto(NumberGenerator generator) {
        this.generator= generator;

    }
    public static int countLotto(int price) {
        int countLotto = price / LOTTO_PRICE;
        return countLotto;
    }
    /*public List<Integer> randomLotto(){
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER,LOTTO_MAX_NUMBER,LOTTO_SIZE);
        List<Integer>lottosort= new ArrayList<>(lotto);
        lottosort.sort(Comparator.naturalOrder());

        return lottosort;
    }*/

    public List<List<Integer>> makeLotto(int countLotto) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i=0; i<countLotto; i++) {
            List<Integer> numbers = generator.generate();
            lottos.add(numbers);
        }
        return lottos;
    }
}
