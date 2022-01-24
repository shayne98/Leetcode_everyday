package leecode.ds.hash.No1;

import java.util.HashMap;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(target-nums[i])){
                return new int[]{i,mp.get(target-nums[i])};
            }
            mp.put(nums[i],i);
        }
        return new int[2];

    }
}