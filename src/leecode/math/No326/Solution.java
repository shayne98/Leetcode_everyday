package leecode.math.No326;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No326. Power of Three
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        int m = 1;
        //m超过Int的范围后就变成负数了
        while(m>0){
            if(m==n)return true;
            m*=3;
        }
        return false;

    }
}