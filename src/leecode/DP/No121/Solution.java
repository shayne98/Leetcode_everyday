package leecode.DP.No121;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public int maxProfit(int[] prices) {
        int Max = 0;
        int minPrice = prices[0];
        for(int i=1;i<prices.length;i++){
            Max = Math.max(Max,prices[i]-minPrice);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return Max;
    }
}