package lotto.model.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i: numbers) {
            if(!set.add(i)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
            }
        }
    }
}
