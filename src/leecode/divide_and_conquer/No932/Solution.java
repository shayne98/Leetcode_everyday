package leecode.divide_and_conquer.No932;

import java.util.HashMap;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No932. Beautiful Array
 * 分治，关键在于怎么把分解子问题，并利用奇偶性把子问题的结果线性增加合并为父问题的答案
 * 此题可以动态规划加快深搜
 */
@SuppressWarnings("all")
public class Solution {
    //用来记录分治过程中中间记录过的结果，防止重复深搜
    HashMap<Integer,int[]> memo = new HashMap<>();
    public int[] beautifulArray(int n) {
        return devide_conquer_N(n);


    }
    public int[] devide_conquer_N(int n){
        int[] arr = new int[n];
        if(n==1){
            //n==1的是分治中最小的情况，直接满足的数组就是一个1
            arr[0]=1;
        }
        //使用memorization加快深搜递归
        else if(memo.containsKey(n)){
            return memo.get(n);
        }
        else{
            int t =0;
            //其余需要递归分治
            //将数组中前(n+1)/2全部设为奇数，后n/2个元素全部设为偶数
            //如此一来跨区域不可能产生等差数列（首位两元素奇偶性必须相同）
            //各区域内用得到已有的分治结果进行线性扩增，区域内也不可能构成等差数列

            for (int elem : devide_conquer_N((n + 1) / 2)) {
                //对于(n+1)/2的情况下范围1~(n+1)/2
                //对于任意元素x，2*x-1的范围1~n中的所有奇数
                arr[t++]=2*elem-1;
            }
            for (int elem : devide_conquer_N(n / 2)) {
                //对于n/2情况下数字范围1~n/2
                //对于任意元素x，2*x的范围是1~n的所有偶数
                arr[t++]=2*elem;
            }
        }
        //采用动态规划记录已经计算过的结果
        memo.put(n,arr);
        return arr;
    }
}
