package Task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LitteredStream {

    public static void main(String[] args) {

        //Варіант 1
        String[] numbers = {"\"1", "2", "\"8", "0\"", "\"4", "5\""};
        System.out.println(Arrays.toString(numbers));

        //Варіант 2
        Object[] numbersObj = {"\"1", "2", "\"8", "0\"", "\"4", "5\""};
        System.out.println(Arrays.toString(numbersObj));

        //Варіант 3
        String[] numbersOther = {"1, 2, 0", "4, 5"};
        System.out.println(Arrays.toString(numbersOther));


        //Варіант 1
        System.out.println(Arrays.stream(numbers)
                .map(n -> n.replace("\"", ""))
                .sorted()
                .collect(Collectors.joining(", ", "\"", "\"")));


        //Варіант 2
        List<Integer> numberList = Arrays.stream(numbersObj)
                .map(n -> n + "")
                .map(n -> n.replace("\"", ""))
                .map(Integer::parseInt)
                .sorted()
                .toList();

        System.out.println(numberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "\"", "\"")));


        //Варіант 3
        List<Integer> numberListOther = Arrays.stream(numbersOther)
                .flatMap(n -> Arrays.stream(n.split("\\s*,\\s*")))
                .map(Integer::parseInt)
                .sorted()
                .toList();

        System.out.println(numberListOther.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "\"", "\"")));

    }
}
