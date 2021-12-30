package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2)return 0;
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>=prices[i-1]){
                profit+= prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}