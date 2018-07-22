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

    public static Set<Long> divisors(long n) {
        return _divisors(n, getPrimes((int) Math.sqrt(n)));
    }

    public static long sum(Collection<Integer> nums) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
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
        if (!divisorsCache.containsKey(n)) {
            divisorsCache.put(n, divisors);
        }
        return divisors;
    }
}
