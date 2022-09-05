/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        //较高的那个立柱往内移动储水量不增
        //所以让较低的那个立柱向内移动
        int left=0,right=height.length-1;
        int res = (right-left)*Math.min(height[left], height[right]);
        while(left<=right){
            res = Math.max(res,(right-left)*Math.min(height[left], height[right]));
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;

    }
}
// @lc code=end

