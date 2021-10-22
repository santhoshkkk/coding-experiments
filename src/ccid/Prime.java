package ccid;

import java.util.ArrayList;
import java.util.List;


public class Prime {


    static List<Integer> allPrimes(int limit) {
        boolean[] nonPrimes = new boolean[limit + 1];
        nonPrimes[0] = true;
        nonPrimes[1] = true;

        for (int i = 0; i < nonPrimes.length; i++) {
            if (!nonPrimes[i]) {
                for (int j = i * i; j < nonPrimes.length; j += i) {
                    nonPrimes[j] = true;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < nonPrimes.length; i++) {
            if (!nonPrimes[i]) {
                primes.add(i);
            }
        }

        return primes;

    }

    public static void main(String[] args) {
        System.out.println(Prime.allPrimes(50000));
    }

}
