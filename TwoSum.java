package problems;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*/

    public int[] twoSum(int[] nums, int target) {

        var inputArray = Arrays.stream(nums).boxed().toList();
        for (int i = 0; i < inputArray.size(); i++) {
            for (int j = 0; j < inputArray.size(); j++) {
                if (i == j) {
                    break;
                }

                var sumResult = inputArray.get(i) + inputArray.get(j);
                if (sumResult == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    // LeetCode Optimized Solution
    public int[] twoSumOptimized(int[] nums, int target) {

        var numToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[] {};
    }
}
