package euler;

import java.util.List;
import java.util.Set;

import static util.Pythgorean.*;
import static util.PrettyPrint.*;
/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * Link: https://projecteuler.net/problem=9
 * 
 * @author abijwe
 */
public class Problem009 {

    public static void main(String[] args) {
        List<Integer> As = possibleAs(1000);
        List<Integer> Bs = possibleBs(1000);
        Set<Integer> cSquares = possibleCSquares(1000);

        for (int a : As) {
            for (int b : Bs) {
                int cS = a*a + b*b;
                if (cSquares.contains(cS)) {
                    int c = (int)Math.sqrt(cS);
                    int sum = a + b + c;
                    if (sum == 1000) {
                        printResult(a * b * c);
                        printResult(String.format("a=%s;b=%s;c=%s", a, b, c));
                    }
                }
            }
        }
    }
}
