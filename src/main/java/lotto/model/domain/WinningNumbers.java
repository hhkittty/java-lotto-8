package lotto.model.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonus;

    public WinningNumbers(List<Integer> winningNumbers, int bonus) {
        this.winningNumbers=List.copyOf(winningNumbers);
        this.bonus=bonus;
    }
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
    public int getBonusNumber() {
        return bonus;
    }
}
