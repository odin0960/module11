package Task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringList {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Petro", "John", "Bill", "Ivan", "Alice", "Mykola", "Sam");

        List<String> sortedNames = names.stream()
                        .map(String::toUpperCase)
                        .sorted(Comparator.reverseOrder())
                        .toList();

        System.out.println(sortedNames);
    }
}
