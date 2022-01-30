package leecode.ds.hash.No217;

import java.util.HashSet;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/1/30 15:30
 * 217. Contains Duplicate简单用set来检查重复就可以了
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
