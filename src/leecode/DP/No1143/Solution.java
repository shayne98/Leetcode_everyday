package leecode.DP.No1143;

import java.util.Arrays;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 1143. Longest Common Subsequence
 * time O(len1*len2) | space O(len1+len2)
 * 涉及两个字符串的动态规划，采用二维数组作为dp数组
 * 两个动态转移方程根据末尾元素对应两种情况
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int len1 = ch1.length;
        int len2 = ch2.length;
        //dp[i][j]表示 text1到i-1位置以及text2到j-1位置最长子序列的长度
        //这里取i-1和j-1是为了不单独处理下标为0的情况
        int dp[][] = new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(ch1[i-1]==ch2[j-1]){
                    //若末尾元素相同，最长子序列长度+1
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    //若末尾元素不同，分别往前退一个元素，取dp的最大值
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];


    }
}