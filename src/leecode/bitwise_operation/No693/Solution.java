package leecode.bitwise_operation.No693;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 693. Binary Number with Alternating Bits
 */
class Solution {
    public boolean hasAlternatingBits(int n) {
        int temp = n+(n>>1);
        if((temp&(temp+1))==0)return true;
        return false;
    }
}