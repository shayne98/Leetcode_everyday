package leecode.bitwise_operation.No338;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No338 counting bits
 * 动态规划，dp[i] = i%2==1?dp[i>>1]+1:dp[i>>1];
 */
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = i%2==1?dp[i>>1]+1:dp[i>>1];
        }
        return dp;

    }
}
