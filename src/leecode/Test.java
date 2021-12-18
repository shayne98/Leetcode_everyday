package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] =1;
        if(n==1)return 0;
        for(int i=2;i<=n;i++){
            dp[i] = 1;
            for(int j=1;j<=i/2;j++){
                dp[i] = Math.max(dp[i],Math.max(j*dp[i-j],(i-j)*dp[j]));
            }
        }
        return dp[n];

    }
}