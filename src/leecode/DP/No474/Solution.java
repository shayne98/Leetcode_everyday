package leecode.DP.No474;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 474. Ones and Zeroes
 * 两个条件约束dp数组空间压缩后是二维
 */
class Solution {
    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        System.out.println(new Solution().findMaxForm(strs,4,3));
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        //dp[p][q]分别表示前i个字符串组成的数组的子数组中满足其中所有字符串中0的数量小于p且1的数量小于q的最大长度
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=len;i++){
            //先获取str[i]中0和1的数量
            char[] ch = strs[i-1].toCharArray();
            int oneNum = ch.length;
            int zeroNum =0;
            for (char c : ch) {
                if(c=='0'){
                    zeroNum++;
                    oneNum--;
                }
            }
            //逆向遍历
            for(int p=m;p>=zeroNum;p--) {
                for(int q=n;q>=oneNum;q--){
                        dp[p][q] = Math.max(dp[p][q],dp[p-zeroNum][q-oneNum]+1);
                }
            }
        }
        return dp[m][n];
    }
}