package leecode.DP.No650;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 650. 2 Keys Keyboard
 * 乘除类的动态规划
 */
class Solution {
    public int minSteps(int n) {
        //dp[i]表示屏幕上出现i个字符所需的最小操作数
        int[] dp = new int[n+1];
        dp[1] = 0;
        for(int i=2;i<=n;i++){
            //dp[i]初始化为全部都是一个字符粘贴得到的
            dp[i]=i;
            for(int j=2;j*j<=i;j++){
                //i%j==0说明i的情况可以由i/j的情况复制粘贴而来
                //i/j到i增加的次数等价于从1增长到j所需要的最少次数
                if(i%j==0){
                    dp[i] = dp[j]+dp[i/j];
                    //此时满足的i/j是最大的，粘贴效果最好，必是最小的
                    break;
                }
            }
        }
        return dp[n];
    }
}