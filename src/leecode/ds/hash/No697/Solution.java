package leecode.ds.hash.No697;

import java.util.HashMap;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/1/30 15:32
 * 697. Degree of an Array
 * 用hashmap来记录第一次出现元素的位置，再用一个数组来记录该位置若为第一个，总共出现的次数
 * 遍历一遍元素，当个数超过当前最大值，更新子序列长度，等于最大值时取子序列的最小值
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
        int len = nums.length,maxTime=0;
        int minLen = len;
        HashMap<Integer,Integer> firstAppear = new HashMap<>();
        int[] appearTimes = new int[len];
        for(int i=0;i<len;i++){
            if(!firstAppear.containsKey(nums[i]))firstAppear.put(nums[i],i);
            int first = firstAppear.get(nums[i]);
            if(++appearTimes[first]>maxTime){
                maxTime = appearTimes[first];
                minLen = i-first+1;
            }
            if(appearTimes[first]==maxTime){
                minLen = Math.min(minLen,i-first+1);
            }
        }
        return minLen;
    }
}