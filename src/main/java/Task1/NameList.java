package Task1;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class NameList {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ivan", "Petro", "John", "Bill", "Ivan", "Alice", "Mykola", "Sam");

        int[] i = {1};
        int[] j = {0};

        String filteredNames = names.stream()
                .map(name -> i[0]++ + ". " + name)
                .filter(name -> j[0]++ % 2 == 0)
                .collect(Collectors.joining(", "));


//        AtomicInteger index1 = new AtomicInteger(1);
//        AtomicInteger index2 = new AtomicInteger(0);
//
//        String filteredNames = names.stream()
//                .map(name -> index1.getAndIncrement() + ". " + name)
//                .filter(name -> index2.getAndIncrement() % 2 == 0)
//                .collect(Collectors.joining(", "));

        System.out.println(filteredNames);
    }
}
