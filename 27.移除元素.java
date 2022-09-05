/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int p=0,q=0;
        for(;p<nums.length;p++){
            if(nums[p]!=val){
                nums[q++] = nums[p];
            }
        }
        return q;

    }
}
// @lc code=end

