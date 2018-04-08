package Array;

import java.util.Arrays;

/**
 * one for loop and one loop of two pointers
 * calculate the smallest gap iteratively
 */
public class Solution_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int gap = Integer.MAX_VALUE;
        int minSum = 0;
        for (int i = 0; i < nums.length-2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) return 0;
                else if (sum < target) {
                    if ((target - sum) < gap) {
                        gap = target - sum;
                        minSum = sum;
                    }
                    start++;
                } else {
                    if ((sum - target) < gap) {
                        gap = sum - target;
                        minSum = sum;
                    }
                    end--;
                }
            }
        }
        return minSum;
    }
}
