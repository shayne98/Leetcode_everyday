package leecode.DP.No70;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public int climbStairs(int n) {
        if(n<=2)return n;
        int s1=2,s2=1;
        for(int i=3;i<=n;i++){
            int temp = s1+s2;
            s2 =s1;
            s1 = temp;
        }
        return s1;
    }
}