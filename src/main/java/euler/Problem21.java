package euler;

import static util.Arithmetic.*;
import static util.PrettyPrint.*;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly
 * into n).
 *
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are
 * called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
 * therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * Link: https://projecteuler.net/problem=21
 * 
 * @author abijwe
 */
public class Problem21 {

    public static void main(String[] args) {
        Map<Long, Long> numVsSumOfDivisors = Maps.newHashMap();
        Map<Long, Long> amicablePairs = Maps.newHashMap();
        for (long i = 10000; i > 3; i--) {
            long sum = sum(properDivisors(i));
            if (numVsSumOfDivisors.containsKey(sum)) {
                long pairSum = numVsSumOfDivisors.get(sum);
                if (pairSum == i) {
                    amicablePairs.put(i, sum);
                }
            }
            numVsSumOfDivisors.put(i, sum);
        }
        long sum = 0;
        for (Map.Entry<Long, Long> entry : amicablePairs.entrySet()) {
            sum += entry.getValue() + entry.getKey();
        }
        printResult(sum);
    }
}
