package Task3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LitteredStream {

    public static void main(String[] args) {

        String[] numbers = {"\"1", "2", "\"8", "0\"", "\"4", "5\""};
        System.out.println(Arrays.toString(numbers));
        Object[] numbersObj = {"\"1", "2", "\"8", "0\"", "\"4", "5\""};

        // Швидкий вивід рядка "чистих" чисел як стрінгів
        System.out.println(Arrays.stream(numbers)
                .map(n -> n.replace("\"", ""))
                .sorted()
                .collect(Collectors.joining(", ")));


        // Або створення очищеного списку з приведенням типів до Integr
        List<Integer> numberList = Arrays.stream(numbersObj)
                .map(n -> n + "")
                .map(n -> n.replace("\"", ""))
                .map(Integer::parseInt)
                .sorted()
                .toList();

        // і роздруківка списку
        System.out.println(numberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
