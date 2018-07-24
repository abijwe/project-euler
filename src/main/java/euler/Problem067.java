package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below,
 * the maximum total from top to bottom is 23.
 * 
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom in triangle.txt
 * (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with
 * one-hundred rows.
 * 
 * Link: https://projecteuler.net/problem=67
 * @author abijwe
 */
public class Problem067 {

    public static void main(String[] args) throws Exception {
        List<Integer[]> data = readData();
        Problem018.solve(data);
    }

    private static List<Integer[]> readData() throws Exception {
        List<Integer[]> result = Lists.newArrayList();
        File file = new File("/Users/winivini/projects/project-euler/data/p067_triangle.txt");
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(reader);
            String line;
            int lineNum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                List<String> data = Splitter.on(' ').splitToList(line);
                Integer[] dataArr = new Integer[++lineNum];
                data.stream().map(str -> Integer.parseInt(str))
                .collect(Collectors.toList())
                .toArray(dataArr);
                result.add(dataArr);
            }
        } finally {
            bufferedReader.close();
            reader.close();
        }
        return result;
    }
}
