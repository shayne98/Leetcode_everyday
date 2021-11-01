package leecode.DP.No139;

import java.util.Arrays;
import java.util.List;

/**
 * @author 小羊Shaun
 * @version 2.0
 * 139. Word Break
 * time O(strLen*(strLen+wordDict.size()))？ | space O(strLen)
 * 分割类动态规划
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //用dp[i]记录前i+1个字符组成的string是否在wordDict存在组合
        int strLen =s.length();
        char[] chars = s.toCharArray();
        boolean[] dp = new boolean[strLen];
        String firstStr = s.substring(0,1);
        dp[0]=wordDict.contains(firstStr)?true:false;
        for(int i=1;i<strLen;i++){
            //遍历s中以s.charAt(i)结尾的所有子序列
            //若s.substring(j,i+1)在wordDict中存在且dp[j-1]为true，则有满足条件的组合
            for(int j=i;j>=0;j--){
                String subStr = String.valueOf(chars,j,i-j+1);
                if((j==0||dp[j-1])&&wordDict.contains(subStr)){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[strLen-1];

    }
}