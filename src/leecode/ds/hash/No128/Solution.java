package leecode.ds.hash.No128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 128. Longest Consecutive Sequence
 * 这题的关键在于怎么做到在搜索的同时删除set中的元素
 * 这里用了一个循环，当set非空时使用迭代器取set的第一个元素，然后在元素的左右进行查找，每找到一个元素就删除set中该元素
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        while(!set.isEmpty()){
           int num = set.iterator().next();
           set.remove(num);
           int left = num-1, right = num+1;
           while (set.contains(left)){
               set.remove(left--);
           }
           while ((set.contains(right))){
               set.remove(right++);
           }
           maxLen = Math.max(maxLen,right-left-1);

        }
        return maxLen;

    }
}