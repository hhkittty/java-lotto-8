package lotto.model.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {
    private final List<List<Integer>> fixedNumbers;
    private int index = 0;

    public FixedNumberGenerator(List<List<Integer>> fixedNumbers) {
        this.fixedNumbers = fixedNumbers;
    }

    @Override
    public List<Integer> generate() {
        List<Integer> unsortedLotto = fixedNumbers.get(index++);
        List<Integer> sortedLotto = new ArrayList<>(unsortedLotto);
        sortedLotto.sort(Comparator.naturalOrder());
        return sortedLotto;
    }
}
