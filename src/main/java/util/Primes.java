package util;

import static util.PrettyPrint.printResult;
import static util.PrettyPrint.printTimeMs;

import java.util.BitSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Sets;

/**
 * Utility methods for prime numbers and prime factors
 * 
 * @author abijwe
 */
public class Primes {

    /**
     * Get all primes less than the given number
     */
    public static Set<Integer> getPrimes(int lessThanThisNumber) {
        int sqrt = (int) Math.sqrt(lessThanThisNumber);
        BitSet set = new BitSet();
        set.set(0, lessThanThisNumber);

        int currPrime = 2;
        while (currPrime <= sqrt) {
            int idx = currPrime;
            while (idx < lessThanThisNumber) {
                idx += currPrime;
                set.clear(idx);
            }
            currPrime = set.nextSetBit(currPrime + 1);
        }

        int idx = 2;
        Set<Integer> primes = Sets.newLinkedHashSet();
        while (idx < lessThanThisNumber) {
            currPrime = set.nextSetBit(idx);
            if (currPrime == -1) break;
            primes.add(currPrime);
            idx = currPrime + 1;
        }
        return primes;
    }

    /**
     * Return true if the given number is prime.
     */
    public static boolean isPrime(int number) {
        Set<Integer> primes = getPrimes(number + 1);
        return primes.contains(number);
    }

    /**
     * Get prime factors for the given number
     */
    public static Set<Integer> getPrimeFactors(final long num) {
        Set<Integer> factors = Sets.newLinkedHashSet();
        Set<Integer> primes = getPrimes((int)Math.sqrt(num));

        primes.forEach(i -> {
            if (num%i == 0) {
                factors.add(i);
            }
        });

        return factors;
    }

    /**
     * Get a factors for the given number
     */
    public static Set<Integer> getAllFactors(final int num) {
        Set<Integer> factors = Sets.newTreeSet();
        Set<Integer> primes = getPrimes((int)Math.sqrt(num));

        primes.forEach(i -> {
            if (num%i == 0) {
                factors.add(i);
                factors.add(num/i);
            }
        });

        return factors;
    }

    public static void main(String[] args) {
        Stopwatch sw = Stopwatch.createStarted();
        Set<Integer> primes = getPrimes(2677);
        printTimeMs(sw.elapsed(TimeUnit.MILLISECONDS));
        printResult(primes.size());
        printResult(primes);
        printResult(isPrime(2679));
    }
}
