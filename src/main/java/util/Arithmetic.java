package util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import static util.Primes.*;

public class Arithmetic {

    private static Map<Long, Set<Long>> divisorsCache = Maps.newHashMap();
    public static long sumN(int n) {
        return n * (n+1) / 2;
    }

    public static long sumNSquare(int n) {
        return n * (n+1) * (2*n + 1) / 6;
    }

    public static long sumNCube(int n) {
        return n * n * (n + 1) * (n + 1) / 4;
    }

    public static Set<Long> properDivisors(long n) {
        Set<Long> divisors = _divisors(n, getPrimes((int)n));
        divisors.remove(n);
        return divisors;
    }

    public static Set<Long> divisors(long n) {
        return _divisors(n, getPrimes((int) Math.sqrt(n)));
    }

    public static <T extends Number> long sum(Collection<T> nums) {
        long sum = 0;
        for (T i : nums) {
            sum += i.longValue();
        }
        return sum;
    }

    private static Set<Long> _divisors(long n, final Set<Integer> primes) {
        if (divisorsCache.containsKey(n)) {
            return divisorsCache.get(n);
        }
        Set<Long> divisors = Sets.newHashSet();
        for (int prime : primes) {
            if (n%prime == 0) {
                divisors.add(n);
                divisors.addAll(_divisors(n/prime, primes));
            }
        }
        divisors.add((long)1);
        divisors.add(n);

        if (!divisorsCache.containsKey(n)) {
            divisorsCache.put(n, divisors);
        }
        return divisors;
    }
}
