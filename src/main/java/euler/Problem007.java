package euler;

import static util.Primes.getPrimes;
import static util.PrettyPrint.printResult;

import java.util.Set;
/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
 * we can see that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 * 
 * Link: https://projecteuler.net/problem=7
 * 
 * @author abijwe
 *
 */
public class Problem007 {

    public static void main(String[] args) {
        Set<Integer> primes = getPrimes(105000);
        Integer[] primesArray = new Integer[primes.size()];
        primes.toArray(primesArray);
        printResult(primesArray[10000]);
    }
}
