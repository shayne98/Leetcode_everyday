package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();
        //dp[i][j]表示到第i和j位置text1 text2最长公共子序列的长度
        int[][] dp = new int[len1+1][len2+1];
        for(int i=1;i<len1;i++){
            for(int j=1;j<len2;j++){
                if(char1[i-1]==char2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}