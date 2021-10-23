package leecode.twoPointers.No680;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution {
    public int[] PalinSub(int l,int r,String s){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))break;
            l++;r--;
        }
        return new int[]{l,r};
    }
    public boolean validPalindrome(String s) {
        int deleteNum =0;
        int[] test = PalinSub(0,s.length()-1,s);
        int l = test[0];
        int r = test[1];
        if(l>=r)return true;
        else{
            test = PalinSub(l+1,r,s);
            if(test[0]<test[1]){
                test = PalinSub(l,r-1,s);
                if(test[0]<test[1])return false;
            }
        }
        return true;
    }
}