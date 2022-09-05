/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int tol = 0;
        for(int i=0;i<nums.length-2;){
            int j =i,d = nums[i+1]-nums[i];
            //找到左端点为nums[i]，公差为nums[i+1]-nums[i]
            //最大连续等差数列的长度
            while(j<nums.length-1&&nums[j+1]-nums[j]==d)j++;
            //an表示长度为3的子数组个数,a1表示长度为j-i+1的数组个数
            int an = j-i+1-2,a1=1;
            tol+=(a1+an)*an/2;
            //下一个起始点应该从j开始,末端点可以继续作为
            //下一个等差数列的左端点存在
            i = j;
        }
        return tol;
        

    }
}
// @lc code=end

