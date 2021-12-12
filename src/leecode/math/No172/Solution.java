package leecode.math.No172;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 172. Factorial Trailing Zeroes
 * 2质数必定比5多，所以只要考虑5的情况
 * 注意学习一下怎么计算n一下某个数的质因数
 */
class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}