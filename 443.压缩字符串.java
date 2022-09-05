/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int id = 0;
        int n = chars.length;
        for(int i=0;i<n;){ 
            int j=i,len = 0,tens = 10,cnt=1;
            char ch =  chars[i];
            chars[id++] = ch;
            while(j<n&&chars[j]==ch){
                j++;
                len++;
                if(len>=tens){
                    cnt++;
                    tens*=10;
                }
            }
            if(cnt==1&&len==1){
                i=j;
                continue;
            }
            for(int k=id+cnt-1;k>=id;k--){
                chars[k] = (char)('0'+len%10);
                len/=10;
            }
            id=id+cnt;
            i = j;
            
        }
        return id;

    }
}
// @lc code=end

