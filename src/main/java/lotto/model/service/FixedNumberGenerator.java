package lotto;

import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {
    private final List<List<Integer>> fixedNumbers;
    private int index = 0;

    public FixedNumberGenerator(List<List<Integer>> fixedNumbers) {
        this.fixedNumbers = fixedNumbers;
    }

    @Override
    public List<Integer> generate() {
        return fixedNumbers.get(index++);
    }
}
