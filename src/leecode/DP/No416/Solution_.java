package leecode.DP.No416;

/**
 * @author 小羊Shaun
 * @version 2.0
 * time O(len*sum/2) | space O(sum/2)
 * 0-1背包空间压缩
 */
public class Solution_ {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum%2==1)return false;
        int target = sum/2;
        //状态转移方程只和上一行有关，所以可以进行空间压缩
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i =1;i<=len;i++){
            //因为状态转移方程需要用到上一行dp[j-nums[i-1]的数据
            //所以需要逆遍历
            for(int j=target;j>0;j--){
                //只需要考虑背包容量大于等于numsp[i-1]
                //其他情况维持不变即可
                if(j>=nums[i-1]){
                    dp[j] = dp[j] ||dp[j-nums[i-1]];
                }
            }
        }
        return dp[target];
    }
}
