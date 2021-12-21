package leecode.DP.No376;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No376. Wiggle Subsequence
 * time O(n^2) | space O(n)
 * dp数组要根据状态转移方程分类为末尾两元素递增或是递减
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        //dp[i]数组含义表示前i个元素组成的子序列中摆动序列长度的最大值
        //关键在于状态转移方程要分为两类，一类是末尾两个元素递增的，一类是末尾两个元素递减的
        //dp_down和dp_up显然各自是不减的
        //从i-1往前找第一个j满足nums[i]比nums[j]大的
        // 此时down[j]代表的一个序列再加上一个nums[i]必能组成一个dp_up的序列
        // 更新dp_up[i] = Max(dp_up[i-1],dp_down[j]+1)
        //同理从i-1往前找第一个j满足nums[i]比nums[j]大的，更新dp_down[i] = Max(dp_down[i-1],dp_up[j]+1)
        int[] dp_down = new int[len];
        int[] dp_up = new int[len];
        dp_down[0]=1;
        dp_up[0]=1;
        for(int i=1;i<len;i++){
            int temp = nums[i];
            dp_down[i] = dp_down[i-1];
            dp_up[i] = dp_up[i-1];
            boolean down =false;
            boolean up =false;
            for(int j=i-1;j>=0;j--){
                if(!down&&temp <nums[j]){
                    dp_down[i] = Math.max(dp_up[j]+1,dp_down[i]);
                    down = true;
                }
                else if(!up&&temp > nums[j]){
                    dp_up[i] = Math.max(dp_down[j]+1,dp_up[i]);
                    up = true;
                }
                if(up&&down) break;
            }
        }
        return Math.max(dp_down[len-1],dp_up[len-1]);
    }
}