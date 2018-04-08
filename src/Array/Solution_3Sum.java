package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * one for loop and one loop of two pointers
 * O(n^2)
 */
public class Solution_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    result.add(Arrays.asList(i, nums[start], nums[end]));
                    do {
                        start++;
                    } while (start < end && nums[start] == nums[start-1]);
                    do {
                        end--;
                    } while (end > start && nums[end] == nums[end+1]);
                } else if(sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }

}
