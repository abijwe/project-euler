package leetcode;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * 
 * Link: https://leetcode.com/problems/palindrome-number/description/
 * 
 * @author abijwe
 */
public class Leet009 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = Integer.toString(x);
        int start = -1;
        int end = s.length();
        while (start++ < end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }

}
