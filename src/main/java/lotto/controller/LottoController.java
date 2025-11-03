package lotto.controller;

import java.util.List;
import lotto.model.domain.WinningNumbers;
import lotto.model.service.RankCalculator;
import lotto.view.InputView;
import lotto.model.service.LottoResult;
import lotto.model.service.MakeLotto;
import lotto.view.OutputView;

public class LottoController {
    private final InputView input;
    private final MakeLotto make;
    private final OutputView output;

    public LottoController(InputView input, MakeLotto make, OutputView output) {
        this.input=input;
        this.make=make;
        this.output=output;
    }
    public void run() {
        int inputPrice = input.inputPrice();
        int countLotto = make.countLotto(inputPrice);
        output.printLottoCount(countLotto);

        List<List<Integer>> lottos = make.makeLotto(countLotto);
        output.printLotto(lottos);

        List<Integer> inputLottoNumbers = input.inputLottoNumbers();
        int bonus = input.inputBonusNumber(inputLottoNumbers);
        WinningNumbers winning = new WinningNumbers(inputLottoNumbers, bonus);

        RankCalculator rankcalculator= new RankCalculator();
        LottoResult result=new LottoResult(rankcalculator);
        List<Integer> calculateRank = result.calculateRank(winning,lottos);
        int totalPrice = result.totalPrize(calculateRank);
        double pnl = result.pnl(totalPrice,inputPrice);

        output.printResult(calculateRank);
        output.printPnl(pnl);
    }
}
