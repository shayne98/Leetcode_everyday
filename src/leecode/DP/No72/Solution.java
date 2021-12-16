package leecode.DP.No72;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No72. Edit Distance
 * 1143的变种题，
 */
@SuppressWarnings("all")
class Solution {
    public int minDistance(String word1, String word2) {
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        int len1 = char1.length;
        int len2 = char2.length;
        int[][] dp = new int[len1+1][len2+1];
        for (int i=0;i<=len1;i++){
            for (int j=0;j<=len2;j++){
                //注意0情况需要特判，和1143的不同之处
                if(i==0){
                    dp[i][j] = j;//增加j个元素
                }
                else if(j==0){
                    dp[i][j] = i;//删除i个元素
                }
                else if(char1[i-1]==char2[j-1]){
                    dp[i][j] = dp[i-1][j-1];//末尾元素相同的情况
                }
                else{
                    int temp = Math.min(dp[i][j-1],dp[i-1][j])+1;//相当于最后再插入一个元素
                    dp[i][j] = Math.min(dp[i-1][j-1]+1,temp);//前者相当于替换一个元素
                }

            }
        }
        return dp[len1][len2];

    }
}