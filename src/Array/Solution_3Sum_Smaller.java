package Array;

import java.util.Arrays;
/**
 * one for loop and one loop of two pointers
 * O(n^2)
 * allow duplicate triplets
 */
public class Solution_3Sum_Smaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
//            if (i != 0 && nums[i] == nums[i-1]) {
//                continue;
//            }
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < target) {
                    count += (end - start);
                    start++;
                    //while (start < end && nums[start-1] == nums[start]) start++;
                } else {
                    end--;
                    //while (start < end && nums[end] == nums[end+1]) end--;
                }
            }
        }
        return count;
    }
}
