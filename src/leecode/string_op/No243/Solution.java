package leecode.string_op.No243;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/4 16:09
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int[] appear1 = new int[26];
        int[] appear2 =  new int[26];
        for(char ch : chars1){
            appear1[ch-'a']++;
        }
        for(char ch : chars2){
            appear2[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(appear1[i]!=appear2[i])return false;
        }
        return true;

    }
}