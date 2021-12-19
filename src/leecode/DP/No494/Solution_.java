package leecode.DP.No494;

/**
 * @author 小羊Shaun
 * @version 2.0
 * 494. Target Sum
 * 动态规划，0-1背包问题
 * 首先根据最大的和确定dp数组的大小，因为有正有负需要将值+sum保证是下标非负
 * 初始化位置随之变化
 */
class Solution_{
    public int findTargetSumWays(int[] nums, int target) {
        int size = nums.length;
        int sum =0;
        for (int num : nums) {
            sum += num;
        }
        if(target>sum||target<-sum)return 0;
        //根据nums数组之和来构造dp数组的大小
        //dp[i][j]中j从0~sum-1下标表示前i个元素运算结果为负数j-sum的组合数
        //j从sum~sum*2表示运算结果为非负整数j-sum的组合数
        int[][] dp = new int[size+1][2*sum+1];
        dp[0][sum] = 1;
        for(int i=1;i<=size;i++){
            int num = nums[i-1];
            for(int j=0;j<2*sum+1;j++){
                //前i-1个元素运算可以得到j+num-sum的情况然后再对第i个元素num作减法
                if(num+j<2*sum+1){
                    dp[i][j] += dp[i-1][j+num];
                }
                //前i-1个元素运算可以得到j-num-sum的情况然后再对第i个元素num作加法
                if(j-num>=0){
                    dp[i][j] += dp[i-1][j-num];
                }
            }
        }
        return dp[size][target+sum];
    }
}
