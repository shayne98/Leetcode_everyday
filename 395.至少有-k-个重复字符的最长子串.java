/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有 K 个重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        
        char[] chars = s.toCharArray();
        int n = chars.length;
        int res=0;
        
        for(int i=1;i<26;i++){
            int chtypes = 0;//表示涉及的字母类型数量
            int chs =0;
            int p=0,q=0;
            int[] times = new int[26];
            for(;q<n;q++){
                int id = chars[q]-'a';
                if(times[id]==0){
                    chtypes++;
                }
                if(times[id]==k-1){
                    chs++;
                }
                times[id]++;
                while(chtypes>i){
                    int tp = chars[p]-'a';
                    if(times[tp]==1){
                        chtypes--;
                    }
                    if(times[tp]==k){
                        chs--;
                    }
                    times[tp]-=1;
                    p++;
                    
                }
                if(chs==chtypes){
                    res = Math.max(res, q-p+1);
                }
            }
        }
        return res;



    }
}
// @lc code=end

