package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.google.common.collect.Lists;
import static util.PrettyPrint.*;

/**
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * Link: https://projecteuler.net/problem=13
 * 
 * @author abijwe
 */
public class Problem013 {

    public static void main(String[] args) throws Exception {
        List<int[]> data = getData();
        List<Integer> result = Lists.newArrayList();
        int j = 0;
        while (j <= 20) {
            int sum = 0;
            int i = 0;
            while (i < data.size()) {
                sum += data.get(i)[j];
                i++;
            }
            insertData(result, sum);
            j++;
        }
        StringBuilder builder = new StringBuilder();
        result.forEach(i -> builder.append(i));
        printResult(builder.toString());
    }

    private static void insertData(List<Integer> result, int sum) {
        if (!result.isEmpty()) {
            int carry = sum/10;
            int i = result.size() - 1;
            while (carry > 0 && i >= 0) {
                int localSum = result.get(i) + carry;
                result.set(i, localSum%10);
                carry = localSum/10;
                i--;
            }
            result.add(sum%10);
            sum = carry;
        }
        while (sum != 0) {
            result.add(0, sum%10);
            sum = sum/10;
        }
    }

    private static List<int[]> getData() throws Exception {
        List<int[]> data = Lists.newArrayList();
        File file = new File("/Users/winivini/projects/project-euler/data/p013_data.txt");
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                char[] chars = line.toCharArray();
                int[] rowData = new int[chars.length];
                int i = 0;
                for (char c : chars) {
                    rowData[i++] = Character.getNumericValue(c);
                }
                data.add(rowData);
            }
        } finally {
            bufferedReader.close();
            reader.close();
        }
        return data;
    }
}
