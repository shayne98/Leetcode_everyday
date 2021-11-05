package leecode.DP.No322;

import java.util.Arrays;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 322. Coin Change
 * time O(len*amount) | space O(amount)
 * 凑硬币，是个完全背包问题，注意空间压缩后内层是正向遍历
 * dp[j]是凑成j的最少硬币数量，注意有多种凑法时，取较小值，以及注意处理-1的情况
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        //dp数组只和这一行和上一行的元素有关
        //可以空间压缩
        int[] dp = new int[amount+1];
        //除了0以外全部初始化为不能凑成即-1
        Arrays.fill(dp,-1);
        dp[0] = 0;
        //dp[j]表示用前i个下标的硬币凑成总价值j的硬币最少数量,-1说明不能凑成
        for(int i=1;i<=len;i++){
            //注意因为状态转移方程需要用到前i个下标凑成总价值小于j的dp元素，必须正向遍历
            for(int j=1;j<=amount;j++){
                //若总价值大于第i个硬币的面值，则凑硬币时可以选择用第i个硬币或者不用
                if(j>=coins[i-1]){
                    //若j-coins[i-1]的总价值可以由前i个下标的硬币凑成，再加一个coins[i-1]就能凑成总价值j
                    //若j的总价值可以由前i-1个下标的硬币凑成，可以选择不添加硬币就能由前i个下标的硬币凑成总价值j
                    if(dp[j-coins[i-1]]!=-1&&dp[j]!=-1){
                        //取硬币数量最少的那种凑法
                        dp[j] = Math.min(dp[j-coins[i-1]]+1,dp[j]);
                    }

                    //若j的总价值不能前i-1个下标的硬币凑成，但是j-coins[i-1]可以由前i个下标的硬币凑成，再加一个coins[i-1]就能凑成总价值j
                    // 因为只有这么一种凑法，直接更新dp[j]
                    else if(dp[j-coins[i-1]]!=-1){
                        dp[j] = dp[j-coins[i-1]] +1;
                    }
                    //其他情况维持现状即可
                }
            }
        }
        return dp[amount];
    }
}