import java.util.List;

/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        char[] chars = s.toCharArray();
        String res = "";
        for(String str:dictionary){
            char[] schars = str.toCharArray();
            int i=0,j=0;
            boolean flag = true;   
            for(;j<schars.length;j++){
                while(i<chars.length&&chars[i]!=schars[j]){
                    i++;
                }
                if(i>=chars.length){
                    flag=false;
                    break;
                }else{
                    i++;
                }
            }
            if(flag&&compare(res, str)){
                res = str;
            }
        }
        return res;
        

    }
    public boolean compare(String s1,String s2){
        if(s1.length()!=s2.length())return s2.length()>s1.length();
        else{
            return s1.compareTo(s2)>0;
        }
    }
}
// @lc code=end

