package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator; // util 패키지에 InputValidator가 있다고 가정
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

class InputViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private InputView inputView;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        inputView = new InputView(new InputValidator());
    }

    @AfterEach
    void tearDown() {
        Console.close();
        System.setOut(standardOut);
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @DisplayName("중복 입력 시 오류 메시지 출력 후 재입력 루프를 통과해야 한다.")
    @Test
    void inputLottoNumbers_RetryOnDuplicate() {
        String input = "1,2,3,4,5,5\n1,2,3,4,5,6";
        provideInput(input);
        List<Integer> result = inputView.inputLottoNumbers();
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(outputStreamCaptor.toString())
                .contains("[ERROR] 로또 번호는 중복이 없어야 합니다.")
                .as("중복 오류 발생 시 오류 메시지가 출력되어야 합니다.");
    }

    @DisplayName("당첨 번호와 중복 입력 시 오류 메시지 출력 후 재입력 루프를 통과해야 한다.")
    @Test
    void inputBonusNumber_RetryOnDuplicate() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String input = "5\n7\n";
        provideInput(input);
        int result = inputView.inputBonusNumber(winningNumbers);
        assertThat(result).isEqualTo(7);
        assertThat(outputStreamCaptor.toString())
                .contains("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.")
                .as("중복 오류 발생 시 오류 메시지가 출력되어야 합니다.");
    }

}

