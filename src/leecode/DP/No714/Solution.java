package leecode.DP.No714;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int days = prices.length;
        if(days<2)return 0;
        int[] buy = new int[2];
        int[] sell = new int[2];
        int[] s1 = new int[2];
        int[] s2 = new int[2];
        buy[0] = -prices[0];
        s1[0] = -prices[0];
        for (int i=1;i<days;i++){
            buy[1] = Math.max(s2[0]-prices[i],sell[0]-prices[i]);
            sell[1] = Math.max(s1[0]+prices[i]-fee,buy[0]+prices[i]-fee);
            s1[1] = Math.max(s1[0],buy[0]);
            s2[1] = Math.max(s2[0],sell[0]);
            s1[0] = s1[1];
            s2[0] = s2[1];
            buy[0] = buy[1];
            sell[0] = sell[1];
        }
        return Math.max(sell[1],s2[1]);

    }
}