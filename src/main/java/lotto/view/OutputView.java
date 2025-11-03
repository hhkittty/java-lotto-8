package lotto;

import java.util.List;

public class OutputView {
    public void printResult(List<Integer> countcorrect) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        Rank[] ranks = Rank.values();
        for ( Rank  rank : Rank.values() ) {
            if(rank == Rank.NONE) continue;
            System.out.println(rank.getDescription() + " - " + countcorrect.get(rank.ordinal()) + "개");
        }
    }
    public void printPnl(double pnl){
        System.out.println("총 수익률은 "+pnl+"%입니다.");
    }
    public void printLotto(List<List<Integer>> lottos){
        for(List<Integer>lotto:lottos){
            System.out.println(lotto);
        }
    }
    public void printLottoCount(int countLotto){
        System.out.println("\n"+countLotto + "개를 구매했습니다.");
    }

}
