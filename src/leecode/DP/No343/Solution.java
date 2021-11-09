package leecode.DP.No343;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 343. Integer Break
 * time O(n^2) | space O(n)
 */
class Solution {
    public int integerBreak(int n) {
        //dp[i]表示i被分割后的最大乘积
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            //dp初始化为i个1相加此时乘积为最小值
            dp[i] = 1;
            for(int j=1;j<i-1;j++){
                    if(dp[i]<dp[i-j]*j){
                        dp[i] = dp[i-j]*j;
                    }//注意还要单个数的情况即i-j和j
                    dp[i] = Math.max(dp[i],(i-j)*j);
            }
        }
        return dp[n];
    }
}