package leecode.DP.No416;

import java.util.Arrays;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 416. Partition Equal Subset Sum
 * time O(len * sum/2) | space O(len*sum)
 * 0-1背包问题
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int num : nums) {
            sum+=num;
        }
        if(sum%2==1)return false;
        sum/=2;
        //dp[i][j]表示前i个物品在背包容量为j的时候，能否装下sum的东西
        boolean[][] dp = new boolean[len+1][sum+1];
        //初始化dp[0][0]为true
        dp[0][0] = true;
        for(int i=1;i<=len;i++){
            for(int j=1;j<=sum;j++){
                //当背包容量小于第i个物品时，放不下，dp[i][j] = dp[i-1][j]
                if(j<nums[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                //当背包容量大于等于第i个物品的体积时，可以选择放或者是不放，放就是看d[i-1][j-nums[i-1]的值
                //不放就是看d[i-1][j]的值，两个里面取或即可
                else{
                    dp[i][j] = dp[i-1][j]||dp[i][j-nums[i-1]];
                }
            }
        }
        return dp[len][sum];
    }
}