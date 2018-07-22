package util;

/**
 * Utility methods for reversing numbers and strings
 * 
 * @author abijwe
 */
public class Palindrome {

    public static <T> boolean isPalindrome(T num) {
        char[] charsInNum = String.valueOf(num).toCharArray();
        int i = 0, j = charsInNum.length - 1;
        while (i < j) {
            if (charsInNum[i++] != charsInNum[j--]) {
                return false;
            }
        }
        return true;
    }
}
