/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int p=0,q=0,prev=nums[0]-1;
        for(;p<nums.length;p++){
            if(prev==nums[p]){
                continue;
            }
            nums[q++] = nums[p];
            prev = nums[p];
        }
        return q;


    }
}
// @lc code=end

