package euler;

import java.util.Map;
import com.google.common.collect.Maps;
import util.Pair;
import static util.PrettyPrint.*;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers
 * finish at 1.
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * Link: https://projecteuler.net/problem=14
 * 
 * @author abijwe
 */
public class Problem014 {

    private static Map<Long, Pair<String, Long>> formulaValByNums = Maps.newHashMapWithExpectedSize(1000000);

    public static void main(String[] args) {
        Pair<String, Long> maxResponse = findSeq(2);
        for (long i = 3; i < 1000000; i++) {
            Pair<String, Long> response = findSeq(i);
            if (response.second() > maxResponse.second()) {
                maxResponse = response;
            }
        }
        printResult(maxResponse.first());
        printResult(maxResponse.second());
    }

    public static Pair<String, Long> findSeq(long num) {
        if (num == 1) {
            return new Pair<String, Long>("1", (long)1);
        }
        if (formulaValByNums.containsKey(num)) {
            return formulaValByNums.get(num);
        }
        long val;
        if (num % 2 == 0) {
           val = num/2;
        } else {
            val = 3 * num + 1;
        }
        Pair<String, Long> valResponse = findSeq(val);
        Pair<String, Long> myResponse = new Pair<>(num + "->" + valResponse.first(), valResponse.second() + 1);
        formulaValByNums.put(num, myResponse);
        return myResponse;
    }
}
