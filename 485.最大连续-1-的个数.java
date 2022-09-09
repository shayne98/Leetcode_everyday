/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续 1 的个数
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length,i=0;
        int res = 0;
        for(;i<n;){
            while(i<n&&nums[i]!=1)i++;
            int j = i;
            int len = 0;
            while(j<n&&nums[j]==1){
                len++;
                j++;
            }
            res = Math.max(res,len) ;
            i = j;
        }
        return res;

    }
}
// @lc code=end

