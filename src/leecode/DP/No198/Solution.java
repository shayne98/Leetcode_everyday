package leecode.DP.No198;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len==2)return Math.max(nums[1],nums[0]);
        if(len==1)return nums[0];
        int s1 =Math.max(nums[1],nums[0]);
        int s2 = nums[0];
        for(int i=2;i<len;i++){
            int temp = s2+nums[i];
            s2 = s1;
            s1 = Math.max(s1,temp);
        }
        return s1;

    }
}