package euler;

import java.util.ArrayList;
import java.util.List;

import static util.PrettyPrint.*;

public class Problem011 {

    private static int[][] given = new int[][] {
            {8,2,22,97,38,15,0,40,0,75,4,5,7,78,52,12,50,77,91,8},
            {49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48,4,56,62,0},
            {81,49,31,73,55,79,14,29,93,71,40,67,53,88,30,3,49,13,36,65},
            {52,70,95,23,4,60,11,42,69,24,68,56,1,32,56,71,37,2,36,91},
            {22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80},
            {24,47,32,60,99,3,45,2,44,75,33,53,78,36,84,20,35,17,12,50},
            {32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70},
            {67,26,20,68,2,62,12,20,95,63,94,39,63,8,40,91,66,49,94,21},
            {24,55,58,5,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72},
            {21,36,23,9,75,0,76,44,20,45,35,14,0,61,33,97,34,31,33,95},
            {78,17,53,28,22,75,31,67,15,94,3,80,4,62,16,14,9,53,56,92},
            {16,39,5,42,96,35,31,47,55,58,88,24,0,17,54,24,36,29,85,57},
            {86,56,0,48,35,71,89,7,5,44,44,37,44,60,21,58,51,54,17,58},
            {19,80,81,68,5,94,47,69,28,73,92,13,86,52,17,77,4,89,55,40},
            {4,52,8,83,97,35,99,16,7,97,57,32,16,26,26,79,33,27,98,66},
            {88,36,68,87,57,62,20,72,3,46,33,67,46,55,12,32,63,93,53,69},
            {4,42,16,73,38,25,39,11,24,94,72,18,8,46,29,32,40,62,76,36},
            {20,69,36,41,72,30,23,88,34,62,99,69,82,67,59,85,74,4,36,16},
            {20,73,35,29,78,31,90,1,74,31,49,71,48,86,81,16,23,57,5,54},
            {1,70,54,71,83,51,54,69,16,92,33,48,61,43,52,1,89,19,67,48}};

    public static void main(String[] args) {
        long maxProduct = 0;
        int i = 0;
        while (i < given.length) {
            long currProduct = calculateMaxProduct(given[i++]);
            maxProduct = currProduct > maxProduct ? currProduct : maxProduct;
        }
        printResult("horizontal = " + maxProduct);

        i = 0;
        while (i < given[0].length) {
            long currProduct = calculateMaxProduct(getVArr(i++));
            maxProduct = currProduct > maxProduct ? currProduct : maxProduct;
        }
        printResult("vertical = " + maxProduct);

        i = 0;
        while (i < given.length) {
            int[] array = getDiagArr(0, i++);
            if (array.length < 4) {
                break;
            }
            long currProduct = calculateMaxProduct(array);
            maxProduct = currProduct > maxProduct ? currProduct : maxProduct;
        }
        printResult("upper diag = " + maxProduct);

        i = 0;
        while (i < given[0].length) {
            int[] array = getDiagArr(i++, 0);
            if (array.length < 4) {
                break;
            }
            long currProduct = calculateMaxProduct(array);
            maxProduct = currProduct > maxProduct ? currProduct : maxProduct;
        }

        printResult("lower diag = " + maxProduct);
    }

    private static int[] getDiagArr(int i, int j) {
        List<Integer> retList = new ArrayList<>();
        while (i < given[0].length && j < given[i].length) {
            retList.add(given[i++][j++]);
        }
        int index = 0;
        int[] retArr = new int[retList.size()];
        for (int num : retList) {
            retArr[index++] = num;
        }
        return retArr;
    }

    private static int[] getVArr(int row) {
        int[] vertArr = new int[given[row].length];
        for (int i = row; i < given[row].length; i++) {
            vertArr[i] = given[i][row];
        }
        return vertArr;
    }

    private static long calculateMaxProduct(int[] array) {
        long maxProduct = 0;
        int start = getValidStart(array, 0);
        if (start == -1) {
            return -1;
        }
        int j = start;
        while(j + 4 < array.length) {
            long currProduct = getProduct(array, j);
            maxProduct = maxProduct > currProduct ? maxProduct : currProduct;
            j++;
        }
        return maxProduct;
    }

    private static long getProduct(int[] row, int start) {
        if (start + 3 >= row.length) {
            return -1;
        }
        return row[start] * row[start+1] * row[start+2] * row[start+3];
    }

    private static int getValidStart(int[] row, int start) {
        int i = start;
        while (i + 4 < row.length) {
            if (row[i] != 0 && row[i+1] !=0
                    && row[i+2] != 0 && row[i+3] != 0) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
