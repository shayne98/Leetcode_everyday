package leecode.ds.stack.No503;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 503. Next Greater Element II
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack();
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        for(int j=0,i=0;j<2*nums.length;i=(i+1)%nums.length,j++){
            while(!stack.empty()&&nums[i]>nums[stack.peek()]){
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return ans;

    }
}