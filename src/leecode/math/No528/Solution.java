package leecode.math.No528;

import java.util.Random;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No528. Random Pick with Weight
 * 利用前缀和数组来实现不同权重的index的随机选取，例如对于[2,14,7]的权重数组1，2属于index0，3~14属于index1，15~22属于index3
 * 注意random的产生随机数的范围是左闭右开，而我们要从1开始取所以random.nextInt(partial_sum[len-1])+1
 * random.nextInt(partial_sum[len-1]+1)会多产生一个零会错误
 * 产生随机数后通过二分法找到对应的index
 */
class Solution {
    int[] partial_sum;
    int len;
    Random random;

    public Solution(int[] w) {
        len = w.length;
        partial_sum = new int[len];
        partial_sum[0] = w[0];
        random = new Random();
        //计算前缀和
        for(int i=1;i<len;i++){
            partial_sum[i] = partial_sum[i-1]+w[i];
        }
    }
    public int pickIndex() {
        int sum = random.nextInt(partial_sum[len-1])+1;
        //利用二分法在前缀和数列中查找sum所属的index
        int left = 0,right =len-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(partial_sum[mid]>sum){
                right = mid-1;
            }
            else if(partial_sum[mid]<sum){
                left = mid+1;
            }
            if(partial_sum[mid] == sum){
                return mid;
            }
        }
        return left;
    }
}
