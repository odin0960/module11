package Task5;

import java.util.*;
import java.util.stream.Stream;

public class SimpleStreamMixer {

    public static void main(String[] args) {
        List<Integer> first1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> second2 = Arrays.asList(1, 2, 3, 4, 5, 6);

//        List<String> first1 = Arrays.asList("A", "B", "C", "D", "E");
//        List<String> second2 = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "I");

        zip(first1.stream(), second2.stream()).forEach(System.out::print);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        //простий метод "перемішування" скінченних стрімів (ПРАЦЮЄ)
//        ==================================================
        List<T> firstList = first.toList();
        List<T> secondList = second.toList();
        int limit = 2 * Math.min(firstList.size(), secondList.size());
        Iterator<T> iterator1 = firstList.stream().iterator();
        Iterator<T> iterator2 = secondList.stream().iterator();

        return Stream.iterate(true, b -> b)
                .flatMap(b -> Stream.of(iterator1.next(), iterator2.next()))
                .limit(limit);
//        ========================================================


//        //ще варіант для скінченних стримів (ПРАЦЮЄ)
////        =================================================
//        List<T> mixer = new ArrayList<>();
//        Iterator<T> iterator1 = first.iterator();
//        Iterator<T> iterator2 = second.iterator();
//        while (iterator1.hasNext() && iterator2.hasNext()) {
//            mixer.add(iterator1.next());
//            mixer.add(iterator2.next());
//        }
//        return mixer.stream();
////        ====================================================


//        //спроба для нескінченних стримів
//        //результат отримується, але код без втручання не завершується чомусь!!!!
//        =============================================================
//        Iterator<T> iterator1 = first.iterator();
//        Iterator<T> iterator2 = second.iterator();
//        Stream<T> resultStream = Stream.iterate(true, b -> b)
//                .flatMap(b -> {
//                    if (iterator1.hasNext() && iterator2.hasNext()) {
//                        return Stream.of(iterator1.next(), iterator2.next());
//                    } else {
////                        throw new NoSuchElementException();
//                        return Stream.empty();
//                    }
//                })
////        .limit(10);   //програму можна зупинити лімітом
//
//        return resultStream;
//        =======================================================================
    }
}

