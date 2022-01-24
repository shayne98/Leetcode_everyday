package leecode.ds.queue.No239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 239. Sliding Window Maximum
 * 是之前单调栈的一个变种题，之前单调栈的题目里面只涉及了一段加元素，不涉及另一端的减元素
 * 所以此题采用双端队列。一段类似单调栈，维持单调性，一段用于移动窗口前部的弹出元素
 * 由于弹出元素需要判断是否在单调栈部分就已经弹出，所以入队的是数组的下标而不是数值
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                ans[i-k+1] = nums[dq.peekFirst()];
            }
            if(dq.peekFirst()==i-k+1)dq.removeFirst();
        }
        return ans;

    }
}