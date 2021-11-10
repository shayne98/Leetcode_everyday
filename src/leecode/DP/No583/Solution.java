package leecode.DP.No583;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 583. Delete Operation for Two Strings
 * time O(len1*len2) | space O(len1*len2)
 * 最长公共子序列的变种
 */
class Solution {
    public int minDistance(String word1, String word2) {
        char[] ch1  = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int len1 = ch1.length;
        int len2 = ch2.length;
        //dp[i][j]表示ch1前i个和ch2前j个的字符串的最长公共子序列长度
        int[][] dp = new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(ch1[i-1]==ch2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        //最少的更改次数就是原来的长度减去最长公共子序列的长度
        return len1+len2-dp[len1][len2]*2;

    }
}