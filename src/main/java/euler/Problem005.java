package euler;

import static util.PrettyPrint.printResult;
/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without
 * any remainder. What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 * 
 * Link: https://projecteuler.net/problem=5
 * @author abijwe
 */
public class Problem005 {

    public static void main(String[] args) {
        // Only for the record. No program needed :)
        long product = 1 * 2 * 3 * 2 * 5 * 1 * 7 * 2 * 3 * 1 * 11 * 1 * 13 * 1 * 1 * 2 * 17 * 1 * 19;
        printResult(product);
    }
}
