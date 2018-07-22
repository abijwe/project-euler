package euler;

import static util.Palindrome.isPalindrome;
import static util.PrettyPrint.printResult;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of
 * two 2-digit numbers is 9009 = 91 × 99. Find the largest palindrome made from the product of two
 * 3-digit numbers.
 * 
 * @Link: https://projecteuler.net/problem=4
 * 
 * @author abijwe
 */
public class Problem004 {

    public static void main(String[] args) {
        int limit = 101;
        int result = 0;

        for (int i = 999; i > limit; i--) {
            for (int j = 999; j > limit; j--) {
                int product = i * j;
                if (isPalindrome(product)) {
                    if (result < product) {
                        result = product;
                    }
                    break;
                }
            }
        }
        printResult(result);
    }
}