package Task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringList {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Petro", "John", "Bill", "Ivan", "Alice", "Mykola", "Sam");

        names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

    }
}
