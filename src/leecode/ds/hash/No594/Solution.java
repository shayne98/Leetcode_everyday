package leecode.ds.hash.No594;

import java.util.HashMap;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/1/30 15:40
 * 594. Longest Harmonious Subsequence
 * 最后答案中必定只有相邻的两个元素，用一个hashmap记录所有元素的出现情况，然后取出所有的key，当相邻的ke也存在时
 * 找两者数量之和最大的
 */
class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result =0;
        for(int num: nums){
            map.computeIfAbsent(num,key->0);
            map.put(num,map.get(num)+1);
        }
        for(int num: map.keySet() ){
            if(map.containsKey(num+1)){
                result = Math.max(result,map.get(num)+map.get(num+1));
            }
        }
        return result;

    }
}