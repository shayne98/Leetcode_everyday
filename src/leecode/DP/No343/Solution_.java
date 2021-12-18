package leecode.DP.No343;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 343. Integer Break
 * 分割类动态规划
 */

class Solution_ {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] =1;//n>=2不碍事
        for(int i=2;i<=n;i++){
            dp[i] = 1;//取全一作为默认值
            for(int j=1;j<=i/2;j++){
                //将i分割为两部分，两部分分别取原值还是继续分割的乘积最大值
                dp[i] = Math.max(dp[i],Math.max(j,dp[j])*Math.max(i-j,dp[i-j]));
            }
        }
        return dp[n];
    }
}