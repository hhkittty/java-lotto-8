package lotto;

import lotto.controller.LottoController;
import lotto.model.service.MakeLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.util.InputValidator;
import lotto.model.service.NumberGenerator;
import lotto.model.service.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputValidator validator = new InputValidator();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        InputView input = new InputView(validator);
        MakeLotto make = new MakeLotto(numberGenerator);
        OutputView output = new OutputView();
        LottoController controller = new LottoController(input,make,output);
        controller.run();
    }
}