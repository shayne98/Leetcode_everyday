package leecode.bitwise_operation.No190;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans =0,i=0;
        while(i<32){
            ans<<=1;
            ans = (n&1)|ans;
            n>>=1;
            i++;
        }
        return ans;

    }
}