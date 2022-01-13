package leecode.bitwise_operation.No476;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public int findComplement(int num) {
        int i=0;
        int ans = 0;
        while(num>0){
            int last = num&1;
            ans += (last^1)<<i++;
            num>>=1;
        }
        return ans;

    }
}