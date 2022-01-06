package leecode.math.No169;

import java.util.HashMap;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
public class Solution_ {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max =0;
        int num = nums[0];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
            if(max<map.get(nums[i])){
                max = map.get(nums[i]);
                num = nums[i];
            }
        }
        return num;
    }
}
