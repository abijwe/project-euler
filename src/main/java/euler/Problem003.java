package euler;

import java.util.Set;
import static util.Primes.getPrimeFactors;
import static util.Primes.isPrime;
import static util.PrettyPrint.printResult;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * Link: https://projecteuler.net/problem=3
 * @author abijwes
 */
public class Problem003 {

    public static void main(String[] args) {
        long number = Long.valueOf("600851475143");

        Set<Integer> primes = getPrimeFactors(number);
        Integer[] primesArray = new Integer[primes.size()];
        primes.toArray(primesArray);
        printResult(primesArray[primesArray.length - 1]);
        printResult(isPrime(6857));
    }
}
