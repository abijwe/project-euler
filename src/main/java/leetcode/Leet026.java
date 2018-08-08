package leetcode;

public class Leet026 {

    public int removeDuplicates(int[] nums) {
        int freeIndex = -1;
        if (nums.length > 0) {
            int i = 0;
            while (i < nums.length) {
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    freeIndex = freeIndex == -1 ? i : freeIndex;
                    i++;
                }
                if (freeIndex != -1) {
                    nums[freeIndex++] = nums[i];
                }
                i++;
            }
        }
        return freeIndex == -1 ? nums.length : freeIndex;
    }
}
