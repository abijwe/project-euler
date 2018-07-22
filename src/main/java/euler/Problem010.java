package euler;

import static util.PrettyPrint.printResult;
import static util.Primes.*;

import java.util.Set;
/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * 
 * Link: https://projecteuler.net/problem=10
 * 
 * @author abijwe
 */
public class Problem010 {

    public static void main(String[] args) {
        Set<Integer> primes = getPrimes(2000000);
        long sum = 0;
        for (int prime : primes) {
            sum+= prime;
        }

        printResult(sum);
    }
}
