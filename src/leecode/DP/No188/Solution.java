package leecode.DP.No188;

import java.util.Arrays;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No188. Best Time to Buy and Sell Stock IV
 *
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        int[] sell = new int[k+1];//sell[i]第i次卖出的最大收益
        int[] buy  = new int[k+1];//buy[i]第i次买入的最大收益
        Arrays.fill(buy,Integer.MIN_VALUE);//由于买入时的收益可能是负的，所以要先赋值为最小的符号整型
        //若天数小于2无法完成一次买卖，直接返回零
        if(days<2)
            return 0;
        //由于在一天里不能同时进行买和卖，所以当天数<2*k时，交易次数必然无法用完
        //只要找到股票价格波动线中全部上升段，起点买入，终点卖出即可
        if(days<2*k){
            return  sellIfProfit(prices);
        }
        for(int i=0;i<days;i++){
            //每次增加一天，状态转移方程关键在于第i天是否买入或者卖出
            //若i天不卖出或者买入，则两个数组维持原状
            //若i天买入，buy[j]更新为第j-1次卖出的最大收益-price[i]
            //若i天卖出，sell[j]更新为第j买入时最大收益+price[i]
            //取两种情况的最大值，注意sell[i]要用到buy[i]，所以要先更新buy
            for(int j=1;j<=k;j++){
                buy[j] = Math.max(buy[j],sell[j-1]-prices[i]);
                sell[j] = Math.max(sell[j],buy[j]+prices[i]);
            }
        }
        return sell[k];
    }
    public int sellIfProfit(int[] prices){
        int max =0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                //这里的意思就是说总是在价格趋势变化时买进或者卖出
                max+=prices[i]-prices[i-1];
            }
        }
        return max;
    }
}