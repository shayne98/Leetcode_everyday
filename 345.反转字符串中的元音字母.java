import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int p = 0,q = chars.length-1;
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        while(p<q){
            if(set.contains(chars[p])){
                while(p<q&&!set.contains(chars[q]))q--;
                if(p>=q)break;
                char ch = chars[p];
                chars[p] = chars[q];
                chars[q] = ch;
                q--;
            }
            p++;
        }
        return new String(chars);


    }
}
// @lc code=end

