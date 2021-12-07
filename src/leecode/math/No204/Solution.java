package leecode.math.No204;

import java.util.Arrays;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 204. Count Primes
 * 输出n以下的质数个数，可以在以下几个方面缩小时间
 * n以下的质数不会超过sqrt(n)
 * 只有奇数可以是质数
 * 奇数的倍数必定不是质数
 * 注意1，2需要特判
 * time O(n^1.5)| space O(n)
 */
class Solution {
    public int countPrimes(int n) {
        //n小于3时需要特判
        if(n<3)return 0;
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        //只有奇数才可能是质数，n以下的奇数个数是n/2
        // 注意2是偶数但是质数但1是奇数不是质数，所以不影响
        int num = n/2;
        //n以下的质数绝不会超过n的开平方
        int sqrt = (int)Math.sqrt(n);
        for(int i=3;i<=sqrt;i+=2){
            if(isPrime[i]==false){
                continue;
            }
            //把n以下的i的倍数且满足是奇数全部标记为false
            for(int j=i*3;j<n;j+=2*i){
                if(isPrime[j]==true){
                    isPrime[j]=false;
                    num--;
                }
            }
        }
        return num;
    }
}