package leecode.DP.No650;

/**
 * @author 小羊Shaun
 * @version 2.0
 * 此题不用动态规划也可，类似递归地去找n的因数
 * time <O(n) | space O(1)
 */

class Solution_ {
    public int minSteps(int n) {
       int res =0;
       int factor = 2;
       while(n>1) {
           //n%factor == 0表示可以由n/factor粘贴factor次得到
           //实质是递归的思想，但是写成了while循环的形式
           //注意检查边界，n==factor时也是符合的
           while (n % factor == 0) {
               res += factor;
               n /= factor;
           }
           factor++;
       }
       return res;

    }
}