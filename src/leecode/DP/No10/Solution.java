package leecode.DP.No10;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No10. Regular Expression Matching
 * 分类讨论，关键就是带星号的情况下，是否要重复，状态转移方程不同
 * 然后要注意重复一次满足的情况下状态转移方程不会剔除'*'，对应的初始情况是dp[0][2*i]等价dp[0][0]，要单独初始化
 */
class Solution {
    public boolean isMatch(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int len1 = sChars.length;
        int len2 = pChars.length;
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0]=true;
        //根据状态转移方程可知，初始状态有两种是true
        // 一种是不带'*'的两个字符串都是零，
        // 一种是带‘*’的重复次数为0，最后等价于第一种情况
        for(int i=2;i<=len2;i+=2){
            if(pChars[i-1]=='*'){
                //初始化要把等价于dp[0][0]带'*'的情况挑出来，因为状态转移重复一次的情况下不会剔除'*'
                dp[0][i] = true;
            }
            else break;
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(pChars[j-1]=='.'){
                    //若最后一个元素pchars[j-1]是'.'直接往前推一个
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pChars[j-1]!='*'){
                    //若最后一个元素是字母，那么比较最后一个元素
                    dp[i][j] = dp[i-1][j-1]&&sChars[i-1]==pChars[j-1];
                }
                else if(pChars[j-2]!='.'){
                    //最后一个元素是'*'
                    //pchars前一个元素pchars[j-2]不是'.'时，'*'只能重复单一的元素
                    //*重复次数为0的情况
                    //*重复次数至少为1的情况
                    dp[i][j] = dp[i][j-2]||(sChars[i-1]==pChars[j-2]&&dp[i-1][j]);
                }
                else{
                    //'.*'这样的组合
                    // 从左到右分别是'.'重复次数为0; '.'至少重复1次 ;
                    dp[i][j] =dp[i][j-2]||dp[i-1][j] ;
                }
            }
        }
        return dp[len1][len2];

    }
}