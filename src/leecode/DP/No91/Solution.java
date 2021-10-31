package leecode.DP.No91;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 91. Decode Ways
 * time O(s.length())|space O(1)
 */
class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        //第一个元素为0的肯定没有满足的
        if(s.charAt(0)=='0')return 0;
        //dp1表示到前一个元素满足题意的答案
        //dp2表示到前两个元素满足题意的答案
        int dp1=1,dp2=1;
        for(int i=1;i<len;i++){
            int prev = s.charAt(i-1)-'0';
            int now = s.charAt(i)-'0';
            int dp_temp;
            //前一个元素和后一个元素可以组合起来的情况
            if(prev==1||(prev==2&&now<=6)){
                //now是0不能单独存在，只能和prev组合
                if(now==0){
                    dp_temp=dp2;
                }
                //now既可以单独存在也可以和prev组合
                else{
                    dp_temp = dp1+dp2;
                }

            }
            //前后元素不能组合的情况
            else{
                //now为0不能单独存在，必定没有满足的
                if(now==0){
                    return 0;
                }
                //只能now单独存在，和dp1一样
                else{
                    dp_temp = dp1;
                }
            }
            //更新dp
            dp2=dp1;
            dp1=dp_temp;

        }
        return dp1;
    }
}