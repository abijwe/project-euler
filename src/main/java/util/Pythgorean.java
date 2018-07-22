package util;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lombok.Data;

public class Pythgorean {

    public static List<Integer> possibleAs(int lessThan) {
        List<Integer> allNums = getNums(lessThan);
        return allNums.stream()
                .filter(num -> num%2==1 && num%3 == 0)
                .collect(Collectors.toList());
    }

    public static List<Integer> possibleASquares(int lessThan) {
        List<Integer> allNums = getNums(lessThan);
        return allNums.stream()
                .filter(num -> num%2==1 && num%3 == 0)
                .map(num -> num*num)
                .collect(Collectors.toList());
    }

    public static List<Integer> possibleBs(int lessThan) {
        List<Integer> allNums = getNums(lessThan);
        return allNums.stream()
                .filter(num -> num%4 == 0)
                .collect(Collectors.toList());
    }

    public static List<Integer> possibleBSquares(int lessThan) {
        List<Integer> allNums = getNums(lessThan);
        return allNums.stream()
                .filter(num -> num%4 == 0)
                .map(num -> num*num)
                .collect(Collectors.toList());
    }

    public static Set<Integer> possibleCs(int lessThan) {
        List<Integer> allNums = getNums(lessThan);
        return allNums.stream()
                .filter(num -> num%2 == 1)
                .collect(Collectors.toSet());
    }

    public static Set<Integer> possibleCSquares(int lessThan) {
        List<Integer> allNums = getNums(lessThan);
        return allNums.stream()
                .filter(num -> num%2 == 1)
                .map(num -> num*num)
                .collect(Collectors.toSet());
    }

    private static List<Integer> getNums(int lessThan) {
        List<Integer> nums = Lists.newArrayListWithExpectedSize(lessThan);
        for (int i = 1; i < lessThan; i++) {
            nums.add(i);
        }
        return nums;
    }

    public static  Triplet newTripletSquares(int aSquare, int bSquare, int cSquare) {
        return new Triplet((int)Math.sqrt(aSquare),
                (int)Math.sqrt(bSquare),
                (int)Math.sqrt(cSquare));
    }

    @Data
    public static class Triplet {
        int a;
        int b;
        int c;
        public Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
