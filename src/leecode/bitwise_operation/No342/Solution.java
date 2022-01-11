package leecode.bitwise_operation.No342;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No342 Power of Four
 * 2的幂次满足n&(n-1)==0,4的幂次在2的基础上1位于奇数位上
 */
class Solution {
    public boolean isPowerOfFour(int n) {
        return n>0&&(n&(n-1))==0&&(n&0x55555555)!=0;

    }
}