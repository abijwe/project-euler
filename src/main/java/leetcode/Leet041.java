package leetcode;

import java.util.BitSet;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
 * Link: https://leetcode.com/problems/first-missing-positive/description/
 * 
 * @author abijwe
 */
public class Leet041 {

    public int firstMissingPositive(int[] nums) {
        BitSet bitSet = new BitSet(nums.length);
        for (int i : nums) {
            if (i > 0 && i <= nums.length) {
                bitSet.set(i-1);
            }
        }
        return bitSet.nextClearBit(0) + 1;
    }
}
