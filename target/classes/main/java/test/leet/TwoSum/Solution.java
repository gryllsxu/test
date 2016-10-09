package test.leet.TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] results = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    results[0] = i + 1;
                    results[1] = j + 1;
                    return results;
                }
            }
        }
        return nums;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] results = {0, 0};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                results[0] = map.get(target - nums[i]);
                results[1] = i + 1;
                return results;
            } else {
                map.put(nums[i], i + 1);
            }
        }
        return nums;
    }

    public int[] twoSum3(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; map.put(numbers[i], ++i)) 
            if (map.containsKey(target - numbers[i])) 
                return new int[]{map.get(target - numbers[i]),i+1};
        return new int[]{0,0};
    }
}
