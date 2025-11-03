package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.domain.Lotto;

public class InputValidator {
    private static final String MsgPriceError0 ="[ERROR] 구입금액은 0보다 커야 합니다.";
    private static final String MsgPriceError1 ="[ERROR] 구입금액은 1000원 단위로 입력가능합니다.";
    private static final String MsgBonusError0 ="[ERROR] 보너스 번호는 1~45 사이여야 합니다.";
    private static final String MsgBonusError1 ="[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.";


    public void validatePrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException(MsgPriceError0);
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(MsgPriceError1);
        }
    }
    public void validateBonus(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(MsgBonusError0);
        }
    }
    public void validateLottoNumber(List<Integer> number) {
        Lotto lotto = new Lotto(number);
    }
    public void validateBonusDuplicate(List<Integer> number,int bonusNumber) {
        Set<Integer> set = new HashSet<>(number);
         if(!set.add(bonusNumber)) {
             throw new IllegalArgumentException(MsgBonusError1);
         }
    }
}
