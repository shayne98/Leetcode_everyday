/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] appears = new int[26];
        int res = 0,n = chars.length;
        char maxCh = chars[0];
        int maxAppear = 1;
        for(int i=0,j=0;j<n;j++){
            char ch = chars[j];
            int id = ch - 'A';
            appears[id] +=1;
            if(appears[id]>maxAppear){
                maxCh = ch;
                maxAppear = appears[id];
            }
            // int remain = k - (j-i+1-maxAppear);
            while(k<j-i+1-maxAppear){
                appears[chars[i]-'A']--;
                if(chars[i]==maxCh){
                    int temp = maxCh-'A';
                    for(int m=0;m<26;m++){
                        if(appears[m]>appears[temp]){
                            maxAppear = appears[m];
                            maxCh = (char)('A'+m);
                            temp = m;
                        }
                    }
                }
                i++;
            }
            res = Math.max(res, j-i+1);
                

        }
        return res;
    }
}
// @lc code=end

