package leecode.DP.No309;

/**
 * @author 小羊Shaun
 * @version 2.0
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * 股票交易状态机
 * 减小开的数组大小
 */
@SuppressWarnings("all")
public class Solution_ {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        //0表示前一天该状态下的最大收益，
        //1表示当天该状态下的最大收益
        int[] buy = new int[2];
        int[] sell = new int[2];
        int[] s1 = new int[2];
        int[] s2 = new int[2];
        buy[0] = -prices[0];
        //s1本来不应该初始化的，因为第二天时前一天不可能位于s1状态，为了统一状态转移方程，s1初始化
        s1[0] = -prices[0];
        for(int i=1;i<days;i++){
            sell[1] = Math.max(s1[0],buy[0])+prices[i];
            s1[1] = Math.max(buy[0],s1[0]);
            buy[1] = s2[0]-prices[i];
            s2[1] = Math.max(s2[0],sell[0]);
            //进入下一个循环是更新数组
            s1[0] =s1[1];
            s2[0] =s2[1];
            buy[0] =buy[1];
            sell[0] =sell[1];
        }
        //最后最大收益产生肯定是卖出后，可能是最后一天卖出后也可能是最后一次卖出后一直处于s2状态
        //取这两者的最大值
        return Math.max(s2[1],sell[1]);
    }
}
