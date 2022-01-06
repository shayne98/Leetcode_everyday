package leecode.math.No169;

import java.util.Arrays;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];

    }
}
