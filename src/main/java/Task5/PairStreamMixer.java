package Task5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class PairStreamMixer {

    public static void main(String[] args) {
        List<Integer> first1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> second2 = Arrays.asList(1, 2, 3, 4, 5, 6);

//        List<String> first1 = Arrays.asList("A", "B", "C", "D", "E");
//        List<String> second2 = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "I");

        zip(first1.stream(), second2.stream()).forEach(System.out::print);
    }


    // метод змішування будь-яких потоків одного типу через створення проміжного об'єкту Pair
    // ПРАЦЮЄ з безскінченними стримами
    static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();
        Iterable<Pair<T,T>> i=()->new Iterator<Pair<T,T>>() {
            public boolean hasNext() {
                return iterator1.hasNext() && iterator2.hasNext();
            }
            public Pair<T,T> next() {
                return new Pair<T,T>(iterator1.next(), iterator2.next());
            }
        };
        return StreamSupport.stream(i.spliterator(), false)
                .flatMap(n -> Stream.of(n.getA(),n.getB()));
    }
}