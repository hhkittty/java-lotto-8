package lotto;

import java.util.List;

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

        LottoResult result = new LottoResult(inputLottoNumbers, bonus, lottos, inputPrice);
        List<Integer> calculateRank = result.calculateRank();
        int totalPrice = result.totalPrice(calculateRank);
        double pnl = result.pnl(totalPrice);

        output.printResult(calculateRank);
        output.printPnl(pnl);
    }
}
