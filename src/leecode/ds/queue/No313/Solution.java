package leecode.ds.queue.No313;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/1 14:26
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        //res表示前n个丑数
        //next[i]表示i下标的质数下一个与res中相乘大于res最大值的最小值
        int[] res = new int[n];
        int[] next = new int[primes.length];
        res[0]=1;
        for(int i=1;i<n;i++){
            //每一次循环寻找下一个丑数
            res[i]= Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                //需要保证此时next[j]和质数相乘大于res[i-1]
                //因为res[i-1]是上一轮的最大值，必然只要改动得到上一轮的next[j]即可
                if(res[next[j]]*primes[j]==res[i-1])next[j]++;
                res[i] =  Math.min(res[i],primes[j]*res[next[j]]);
            }
        }
        return res[n-1];
    }
}
