package leecode.DP.No714;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * 股票交易状态，可以简化到两个状态，注意初始值的设置
 */
public class Solution_{
    public int maxProfit(int[] prices, int fee) {
        //表示上一天是买或者卖的最大收益
        //状态机，注意只要买了不卖的状态就是bought状态
        //卖了不买就是sold状态
        int bought = -prices[0];
        int sold = 0;
        for (int i=1;i<prices.length;i++){
            int presold = sold;
            sold = Math.max(bought+prices[i]-fee,sold);
            bought = Math.max(bought,presold-prices[i]);
        }
        return sold;
    }
}
