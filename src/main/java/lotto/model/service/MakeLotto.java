package lotto.model.service;

import java.util.ArrayList;
import java.util.List;

public class MakeLotto {
    private static final int LOTTO_PRICE = 1000;
    private final NumberGenerator generator;

    public MakeLotto(NumberGenerator generator) {
        this.generator= generator;

    }
    public static int countLotto(int price) {
        int countLotto = price / LOTTO_PRICE;
        return countLotto;
    }
    public List<List<Integer>> makeLotto(int countLotto) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i=0; i<countLotto; i++) {
            List<Integer> numbers = generator.generate();
            lottos.add(numbers);
        }
        return lottos;
    }
}
