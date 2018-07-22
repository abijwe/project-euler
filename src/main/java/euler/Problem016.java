package euler;

import java.util.List;

import com.google.common.collect.Lists;
import static util.PrettyPrint.*;
import static util.Arithmetic.*;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 * 
 * Link: https://projecteuler.net/problem=16
 * 
 * @author abijwe
 */
public class Problem016 {

    public static void main(String[] args) {
        List<Integer> twoPow1000 = Lists.newArrayList();
        List<Integer> twoPow1000Temp = Lists.newArrayList();
        twoPow1000.add(2);
        int pow = 2;
        int carry = 0;
        while(pow <= 1000) {
            int index = 0;
            while (index < twoPow1000.size()) {
                int product = twoPow1000.get(index)*2 + carry;
                twoPow1000Temp.add(index, product%10);
                carry = product/10;
                index++;
            }
            if (carry > 0) {
                twoPow1000Temp.add(carry);
            }
            pow++;
            carry = 0;
            twoPow1000 = twoPow1000Temp;
            twoPow1000Temp = Lists.newArrayList();
        }
        printResult(sum(twoPow1000));
    }
}
