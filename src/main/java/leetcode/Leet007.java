package leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Link: https://leetcode.com/problems/reverse-integer/description/
 * 
 * @author abijwe
 */
public class Leet007 {

    public int reverse(int x) {
        long y = Math.abs(x);
        long reverse = 0;
        while (y > 0) {
            reverse = reverse * 10 + (y % 10);
            if (reverse > Integer.MAX_VALUE) {
                return 0;
            }
            y = y/10;
        }
        return (int)(x > 0 ? reverse : -1*reverse);
    }

}
