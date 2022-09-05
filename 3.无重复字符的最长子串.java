import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //双指针
        char[] chars = s.toCharArray();
        int maxLen =0;
        //s 由英文字母、数字、符号和空格组成
        Set<Character> set = new HashSet<>();
        int i=0,j=0;
        for(;j<chars.length;j++){
            char ch = chars[j];
            if(!set.contains(ch)){
                set.add(ch);
                maxLen = Math.max(maxLen,j-i+1);
                continue;
            }
            while(chars[i++]!=chars[j]){
                set.remove(chars[i-1]);
            }
        }
        return maxLen;

    }
}
// @lc code=end

