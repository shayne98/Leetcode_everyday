package leecode.greedy.No122;

class Solution {
    public int maxProfit(int[] prices) {
        int dayNum=prices.length;
        int profit =0;
        int start = 0;
        while(start<dayNum-1){
            if(prices[start+1]>prices[start]){
                //到达谷底点，买进
                int end = start+1;
                while(end<dayNum&&prices[end]>prices[end-1])end++;
                profit+=prices[end-1]-prices[start];
                start=Math.max(end-1,start+1);
            }
            else start++;
        }
        return profit;

    }
}
class Solution_{
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1;i<prices.length;i++) profit += Math.max(0, prices[i] - prices[i - 1]);
        return profit;
    }
}