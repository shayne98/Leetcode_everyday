package leecode.sorting.No347;

import java.util.*;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution_{
    //O(n) time|O(n) space
    public int[] topKFrequent(int[] nums, int k) {
        int max_count = 0;
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for (int num : nums) {
            int current_value = hashmap.getOrDefault(num,0)+1;
            hashmap.put(num,current_value);
            max_count = Math.max(max_count,current_value);
        }
        List<Integer>[] bucket = new ArrayList[max_count+1];
        for (int i=0;i<=max_count;i++)bucket[i] = new ArrayList<Integer>();
        for(Map.Entry entry:hashmap.entrySet())
            bucket[(int)entry.getValue()].add((int)entry.getKey());
        int[] ans = new int[k];
        for(int i=max_count;i>=0&&k>0;i--){
            for (Object an : bucket[i]) {
                ans[--k]=(int)an;
            }
        }
        return ans;

    }
}
