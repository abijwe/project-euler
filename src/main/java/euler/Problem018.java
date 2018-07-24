package euler;

import java.util.List;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import static util.PrettyPrint.printResult;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below,
 * the maximum total from top to bottom is 23.
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * That is, 3 + 7 + 4 + 9 = 23.
 * Find the maximum total from top to bottom of the triangle below:
 * 
 * Link: https://projecteuler.net/problem=18
 * 
 * @author abijwe
 */
public class Problem018 {

    public static void main(String[] args) {
        List<Integer[]> data = Lists.newArrayList();
        data.add(new Integer[]{ 75 });
        data.add(new Integer[]{ 95, 64});
        data.add(new Integer[]{ 17, 47, 82 });
        data.add(new Integer[]{ 18, 35, 87, 10 });
        data.add(new Integer[]{ 20, 4, 82, 47, 65 });
        data.add(new Integer[]{ 19, 1, 23, 75, 3, 34 });
        data.add(new Integer[]{ 88, 2, 77, 73, 7, 63, 67 });
        data.add(new Integer[]{ 99, 65, 4, 28, 6, 16, 70, 92 });
        data.add(new Integer[]{ 41, 41, 26, 56, 83, 40, 80, 70, 33 });
        data.add(new Integer[]{ 41, 48, 72, 33, 47, 32, 37, 16, 94, 29 });
        data.add(new Integer[]{ 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14 });
        data.add(new Integer[]{ 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57 });
        data.add(new Integer[]{ 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48 });
        data.add(new Integer[]{ 63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31 });
        data.add(new Integer[]{ 4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23 });

        solve(data);
    }

    public static void solve(List<Integer[]> data) {
        Multimap<Integer, Integer> result = HashMultimap.create();
        Multimap<Integer, Integer> temp = HashMultimap.create();
        temp.put(0, data.get(0)[0]);
        for (int i = 1; i < data.size(); i++) {
            Integer[] next = data.get(i);
            for (int key : temp.keys()) {
                int max = 0;
                // Only the biggest value at any index matters
                for (int val : temp.get(key)) {
                    max = val > max ? val : max;
                }
                result.put(key, max + next[key]);
                result.put(key + 1, max + next[key + 1]);
            }
            temp = result;
            result = HashMultimap.create();
        }
        // find max
        int max = 0;
        for (int key : temp.keys()) {
            for (int val : temp.get(key)) {
                max = max < val ? val : max;
            }
        }
        printResult(max);
    }
}
