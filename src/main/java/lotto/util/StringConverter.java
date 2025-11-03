package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConverter {

    public static List<Integer> toList(String number) {
        String[] numbers = number.split(",");
        List<Integer> numberlist = Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return numberlist;
    }
}
