package euler;

import static util.PrettyPrint.printResult;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural numbers and the
 * square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers
 * and the square of the sum.
 * 
 * Link - https://projecteuler.net/problem=6
 * 
 * @author abijwe
 */
public class Problem006 {

    public static void main(String[] args) {
        long result = (long) (100*(3*Math.pow(100, 3) + 2*Math.pow(100, 2) - 3*100 - 2)/12); 
        printResult(result);
    }
}
