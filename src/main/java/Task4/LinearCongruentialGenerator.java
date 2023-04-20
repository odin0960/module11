package Task4;

import java.util.stream.Stream;

public class LinearCongruentialGenerator {

    public  Stream<Long> randomizer(long a, long c, long m){
        long seed = 0;

        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) {

        long a = 25214903917L;
        long c = 11L;
        long m = 2^48L;
        int limit = 10;   //задається кількість згенерованих чисел

        LinearCongruentialGenerator random = new LinearCongruentialGenerator();

        random.randomizer(a,c,m)
                .limit(limit)
                .forEach(System.out::println);
    }
}
