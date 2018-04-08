package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * two outer for loops + one for loop of two pointers
 * O(n^3)
 */
public class Solution_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length - 2; j++) {
                if (j != i+1 && nums[j] == nums[j-1]) continue;
                int start = j+1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    System.out.println(sum);
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                        while (start < end && nums[start-1] == nums[start]) start++;
                        while (start < end && nums[end+1] == nums[end]) end--;
                    } else if (sum < target) {
                        start++;
                        while (start < end && nums[start-1] == nums[start]) start++;
                    } else {
                        end--;
                        while (start < end && nums[end+1] == nums[end]) end--;
                    }
                }
            }
        }
        return result;
    }

}
