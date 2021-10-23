package leecode.greedy.No665;

import java.util.HashMap;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        int change =0;
        for(int i=0;i<nums.length-1&&change<2;i++){
            //默认i以前的元素已经满足条件了
            if(nums[i]>nums[i+1]){
                change++;
                //为了尽量减少后面元素的影响，应该对i+1序号的元素增量尽量改到最小
                //但是若i是首个元素，改i号元素较好
                //或者i-1号元素本身就小于等于nums[i+1]那么改i号元素是最好的
                if(i==0||nums[i-1]<=nums[i+1])nums[i]=nums[i+1];
                //其他情况下不能改动i号元素，因为会牵连i-1号元素,因此i+1号元素加到i号元素的大小是刚好满足的最小情况
                else nums[i+1]=nums[i];
            }
        }
        return change<2;


    }
}
