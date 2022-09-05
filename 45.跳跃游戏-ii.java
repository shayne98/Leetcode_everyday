/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        //dp数组表示0到改点需要走的最小步数
        int[] dp = new int[n];
        for(int i=1,j=0;i<n;i++){
            while(j+nums[j]<i)j++;
            dp[i] =dp[j] +1;
        }
        return dp[n-1];

    }
}
// @lc code=end

