package leecode.DP.No309;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 股票交易存在冷却期时使用状态机来解决
 */
class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int[] buy = new int[days];
        int[] sell = new int[days];
        int[] s1 = new int[days];
        int[] s2 = new int[days];
        buy[0] = -prices[0];
        s1[0] = -prices[0];
        for(int i=1;i<days;i++){
            sell[i] = Math.max(s1[i-1],buy[i-1])+prices[i];
            s1[i] = Math.max(buy[i-1],s1[i-1]);
            buy[i] = s2[i-1]-prices[i];
            s2[i] = Math.max(s2[i-1],sell[i-1]);
        }
        return Math.max(s2[days-1],sell[days-1]);
    }
}