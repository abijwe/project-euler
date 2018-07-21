package euler;

import static util.PrettyPrint.printResult;
/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9.
 * The sum of these multiples is 23. Find the sum of all the
 * multiples of 3 or 5 below 1000.
 * 
 * Link: https://projecteuler.net/problem=1
 * 
 * @author abijwe
 */
public class Problem001 {

    // Pure math solution
    public static void main(String[] args) {
        // number of multiples of 3
        int multiplesOf3 = 999/3;
        //sum of those multiples?
        //3 + 6 +9 = 3 + 2(3) +3(3) = 3 n(n+1)/2
        int sum3 = 3 * multiplesOf3 * (multiplesOf3 + 1)/2;

        int multiplesOf5 = 999/5;
        int sum5 = 5 * multiplesOf5 * (multiplesOf5 + 1)/2;

        int multiplesOf15 = 999/15;
        int sum15 = 15 * multiplesOf15 * (multiplesOf15 + 1)/2;

        int result = sum3 + sum5 - sum15;
        printResult(result);
    }
}