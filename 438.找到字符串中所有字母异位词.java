import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] schars = s.toCharArray();
        char[] pchars = p.toCharArray();
        int n = schars.length;
        int[] pAppears = new int[26];
        int[] sAppears = new int[26];
        int pCnt = 0,sCnt=0;
        for(char ch:pchars){
            int id = ch-'a';
            if(pAppears[id]==0)pCnt++;
            pAppears[id]++;
        }
        for(int i=0,j=0;i<n&&j<n;){
            int jId = schars[j]-'a';
            if(pAppears[jId]==0){
                Arrays.fill(sAppears, 0);
                j++;
                i = j;
                sCnt=0;
                continue;
            }
            sAppears[jId]++;
            if(sAppears[jId]==pAppears[jId]){
                sCnt++;
            }
            while(sAppears[jId]>pAppears[jId]){
                int iId = schars[i]-'a';
                if(sAppears[iId]==pAppears[iId]){
                    sCnt--;
                }
                sAppears[iId]--;
                i++;
            }
            if(sAppears[jId]==pAppears[jId]&&sCnt==pCnt){
                res.add(i);
            }
            j++;
            



        }
        return res;

    }
}
// @lc code=end

