package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResult {
    private final List<Integer> lottoNumber;
    private final int bonus;
    private final List<List<Integer>> RandomLottos;
    private final int inputPrice;

    public LottoResult(List<Integer> lottoNumber,int bonusNumber,List<List<Integer>> RandomLottos,int inputPrice){
        this.lottoNumber= lottoNumber;
        this.bonus=bonusNumber;
        this.RandomLottos= RandomLottos;
        this.inputPrice= inputPrice;
    }
    public int countSame( List<Integer> randomnum) {
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

    public List<Integer> calculateRank(){
        List<Integer> rankCount=new ArrayList<>(Arrays.asList(0,0,0,0,0,0));
        for(List<Integer> lotto: RandomLottos) {
            int countSame= countSame(lotto);
            boolean checkBonus=checkBonus(bonus,lotto);

            Rank rank = Rank.findRank(countSame, checkBonus);
            rankCount.set(rank.ordinal(),rankCount.get(rank.ordinal())+1);
        }
        return rankCount;
    }
    public int totalPrice(List<Integer> totalCountCorrect){
        int sum=0;
        Rank[] ranks=Rank.values();
        for(int i=0;i<ranks.length;i++){
            sum+=ranks[i].getPrize()*totalCountCorrect.get(i);
        }
        return sum;
    }
    public double pnl(int totalPrice){
        double pnl = totalPrice/(double)inputPrice*100;
        pnl=Math.round(pnl*100.0)/100.0;
        return pnl;
    }
}
