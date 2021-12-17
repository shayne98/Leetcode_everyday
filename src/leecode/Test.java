package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")

class Solution {
    public static void main(String[] args) {
        new Solution().minSteps(6);
    }
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for(int i=2;i<=n;i++){
            dp[i] = i;
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                    int num = i/j;
                    dp[i] = dp[num]+j;
                }
            }
        }
        return dp[n];
    }
}