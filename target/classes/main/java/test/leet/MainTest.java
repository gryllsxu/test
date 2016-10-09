package test.leet;

import test.leet.TwoSum.Solution;

public class MainTest {

    public static void main(String[] args) {
        Solution twoSum = new Solution();
        int[] nums = {-1,-2,-3,-4,-5};
        int[] result = twoSum.twoSum2(nums, -8);
        System.out.println(result[0] + "_" + result[1]);
    }
}
