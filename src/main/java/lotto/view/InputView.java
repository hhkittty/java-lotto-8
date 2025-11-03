package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.InputValidator;
import lotto.util.StringConverter;

public class InputView {
    private static final String Msg_Input_Price = "구입금액을 입력해 주세요." ;
    private static final String Msg_Input_Lotto = "\n당첨 번호를 입력해 주세요." ;
    private static final String Msg_Input_Bonus = "\n보너스 볼을 입력해 주세요." ;
    private final InputValidator validate;

    public InputView(InputValidator validate) {
        this.validate = validate;
    }
    public int inputPrice() {
            while (true) {
                try {
                    System.out.println(Msg_Input_Price);
                    String inputPrice = Console.readLine();
                    int price = Integer.parseInt(inputPrice);
                    validate.validatePrice(price);

                    return price;

                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] 숫자만 입력해주세요.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        public List<Integer> inputLottoNumbers() {
            while (true) {
                try {
                    System.out.println(Msg_Input_Lotto);
                    String number = Console.readLine();
                    List<Integer> numberList= StringConverter.toList(number);
                    validate.validateLottoNumber(numberList);

                    return numberList;
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] 숫자만 입력해주세요.");
                }catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        public int inputBonusNumber(List<Integer> numberList) {
            while (true) {
                try {
                    System.out.println(Msg_Input_Bonus);
                    String bonus = Console.readLine();
                    int bonusNumber = Integer.parseInt(bonus);
                    validate.validateBonus(bonusNumber);
                    validate.validateBonusDuplicate(numberList, bonusNumber);

                    return bonusNumber;

                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] 숫자만 입력해 주세요.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
}
