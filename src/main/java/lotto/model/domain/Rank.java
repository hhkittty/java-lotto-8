package lotto.model.domain;

import java.util.Arrays;

public enum Rank {
    THREE(3, false, 5000, "3개 일치 (5,000원)"),
    FOUR(4, false, 50000, "4개 일치 (50,000원)"),
    FIVE(5, false, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_BONUS(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(6, false, 2000000000, "6개 일치 (2,000,000,000원)"),
    NONE(0, false, 0, "");

    private final int matchCount;
    private final boolean bonus;
    private final int prize;
    private final String description;

    Rank(int matchCount, boolean bonus, int prizeMoney, String description) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prizeMoney;
        this.description = description;
    }
    public int getMatchCount() {return matchCount;}
    public boolean isBonus() {return bonus;}
    public  int getPrize() {return prize;}
    public String getDescription() {return description;}

    public static Rank findRank (int matchCount, boolean bonusMatched){
        return Arrays.stream(Rank.values())
                .filter(r -> {
                    if (r.getMatchCount() != matchCount) {
                        return false;
                    }
                    return matchCount != 5 || (r.isBonus() == bonusMatched);
                })
                .findFirst()
                .orElse(NONE);
    }
}
