package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * 
 * Link - https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * 
 * @author abijwe
 */
public class Leet003 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> alreadySeen = new HashSet<>(s.length());
        int maxLength = 0, startIndex = 0, i = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (alreadySeen.contains(c)) {
                int subStrLen = i - startIndex;
                maxLength = maxLength > subStrLen ? maxLength : subStrLen;
                startIndex = getNewStartIndex(s, startIndex, i, alreadySeen);
            }
            alreadySeen.add(c);
        }
        int subStrLen = i - startIndex;
        maxLength = maxLength > subStrLen ? maxLength : subStrLen;
        return maxLength;
     }

    private static int getNewStartIndex(String s, int startIndex, int endIndex, Set<Character> alreadySeen) {
        char c = s.charAt(endIndex);
        int index = endIndex - 1;
        while (index > startIndex) {
            if (s.charAt(index) == c) {
                break;
            }
            index--;
        }
        alreadySeen.remove(c);
        for (int i = startIndex; i < index; i++) {
            alreadySeen.remove(s.charAt(i));
        }
        return index + 1;
    }

}
