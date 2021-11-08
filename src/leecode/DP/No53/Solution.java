package leecode.DP.No53;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        //dp表示第i个元素为末尾构成的连续序列的最大和
        int dp = nums[0];
        int max = dp;
        for(int i=1;i<len;i++){
            dp = Math.max(dp+nums[i],nums[i]);
            //更新最大和max
            if(max<dp){
                max = dp;
            }
        }
        return max;
    }
}