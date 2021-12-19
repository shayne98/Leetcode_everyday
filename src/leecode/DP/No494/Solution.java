package leecode.DP.No494;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
//    public static void main(String[] args) {
//        System.out.println(new Solution().findTargetSumWays(new int[]{1,1,1,1,1},3));
//    }
    public int findTargetSumWays(int[] nums, int target) {
        int size = nums.length;
        //dp[i][j]表示用前i个数字组成运算结果为j的情况
        //注意要考虑负的情况所以再开个dn数组考虑负数情况
        int[][] dp = new int[size+1][1001];
        dp[0][0] = 1;
        int[][] dn = new int[size+1][1001];
        dn[0][0] = 1;
        for(int i=1;i<=size;i++){
            int temp = nums[i-1];
            for(int j=-1000;j<=0;j++){
                if(j-temp>=-1000){
                    dn[i][-j] +=dn[i-1][-j+temp];
                }
                if(j+temp<=0){
                    dn[i][-j] += dn[i-1][-j-temp];
                }
                if(j+temp>0){
                    dn[i][-j] += dp[i-1][j+temp];
                }
            }
            for(int j=0;j<=1000;j++){
                if(j-temp>=0){
                    dp[i][j] += dp[i-1][j-temp];
                }
                if(j-temp<0){
                    dp[i][j] += dn[i-1][-j+temp];
                }
                if(j+temp<=1000){
                    dp[i][j] += dp[i-1][j+temp];
                }
            }
        }
        if(target>=0)return dp[size][target];
        else return dn[size][-target];


    }
}