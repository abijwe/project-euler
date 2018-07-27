package euler;

import java.util.Map;

import com.google.common.collect.Maps;
import static util.PrettyPrint.*;

public class Problem017 {

    private static Map<Integer, Integer> NUMS = Maps.newHashMap();
    static {
        NUMS.put(1, "one".length()); NUMS.put(2, "two".length()); NUMS.put(3, "three".length());
        NUMS.put(4, "four".length()); NUMS.put(5, "five".length()); NUMS.put(6, "six".length());
        NUMS.put(7, "seven".length()); NUMS.put(8, "eight".length()); NUMS.put(9, "nine".length());
        NUMS.put(10, "ten".length()); NUMS.put(11, "eleven".length());
        NUMS.put(12, "twelve".length()); NUMS.put(13, "thirteen".length());
        NUMS.put(14, "fourteen".length()); NUMS.put(15, "fifteen".length());
        NUMS.put(16, "sixteen".length()); NUMS.put(17, "seventeen".length());
        NUMS.put(18, "eighteen".length()); NUMS.put(19, "nineteen".length());
        NUMS.put(20, "twenty".length()); NUMS.put(30, "thirty".length());
        NUMS.put(40, "forty".length()); NUMS.put(50, "fifty".length());
        NUMS.put(60, "sixty".length()); NUMS.put(70, "seventy".length());
        NUMS.put(80, "eighty".length()); NUMS.put(90, "ninety".length());
        NUMS.put(100, "hundred".length()); NUMS.put(0, 0);
    }

    public static void main(String[] args) {
        int count1to9 = count1to9();
        int count10to19 = count10to19();
        int count20to99 = count20to99(count1to9);
        int count100to999 = count100to999(count1to9 + count10to19 + count20to99);
        int num = count1to9 + count10to19 + count20to99 + count100to999 + "one".length() + "thousand".length();
        printResult(num);
    }

    private static int count1to9() {
        int sum = 0;
        for (int i = 1; i<= 9; i++) {
            sum += NUMS.get(i);
        }
        return sum;
    }

    private static int count10to19() {
        int sum = 0;
        for (int i = 10; i<= 19; i++) {
            sum += NUMS.get(i);
        }
        return sum;
    }

    private static int count20to99(int count1to9) {
        int sum = 0;
        for (int i = 20; i<= 99; i=i+10) {
            sum += count1to9 + 10*NUMS.get(i);
        }
        return sum;
    }

    private static int count100to999(int count1to99) {
        int sum = 0;
        int hundredAnd = NUMS.get(100) + "and".length();
        for (int i = 100; i <= 999; i=i+100) {
            sum +=  NUMS.get(i/100) + NUMS.get(100) + (99*(NUMS.get(i/100) + hundredAnd) + count1to99);
        }
        return sum;
    }
}
