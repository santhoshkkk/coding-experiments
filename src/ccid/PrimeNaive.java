package ccid;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNaive {

    static boolean isPrime(int num) {
        for(int i=2; i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    static List<Integer> allPrimes(int limit) {
        return IntStream.range(2, limit).filter(PrimeNaive::isPrime).boxed().collect(Collectors.toList());

    }

    public static void main(String[] args) {
        System.out.println(PrimeNaive.allPrimes(10000000));
    }

}
