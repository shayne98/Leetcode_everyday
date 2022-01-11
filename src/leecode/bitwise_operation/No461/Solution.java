package leecode.bitwise_operation.No461;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No461. Hamming Distance
 * 用位运算计算不同位的数量加快速度
 */
class Solution {
    public int hammingDistance(int x, int y) {
        //用异或来统计不同位的个数
        int diff = x^y;
        int sum = 0;
        while(diff > 0){
           sum += diff & 1;
           diff >>= 1;
        }
        return sum;
    }
}
