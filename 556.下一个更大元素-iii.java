import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=556 lang=java
 *
 * [556] 下一个更大元素 III
 */

// @lc code=start
class Solution {
    public int nextGreaterElement(int n) {
        //改动最小的位
        Integer[] bits = new Integer[10];
        int m =n,id=0;
        int res = -1;
        while(m>0){
            bits[id++]=m%10;
            m/=10;
        }
        for(int i=1;i<id;i++){
            if(bits[i]>=bits[i-1])continue;
            //从i-1到0一定是不增的
            //通过二分找到第一个比bit[i]大的位置换位
            //从0~i-1的位置重排降序排列
            int p=0,q=i-1;
            while(p<=q){
                int mid = (p+q)/2;
                if(bits[mid]>bits[i]){
                    q=mid-1;
                }else{
                    p = mid+1;
                }
            }
            int temp = bits[i];
            bits[i] = bits[p];
            bits[p] = temp;
            Arrays.sort(bits,0,i,new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    // A.compareTo(B) A>B 返回1，A=B 返回0，A<B 返回-1
                      // compareTo()返回值>0就交换
                      // 如果02 > o1 就交换 =>降序
                    return o2.compareTo(o1);
            }});
            long ten = 1;
            long sum=0L;
            for(int k=0;k<id;k++){
                sum +=bits[k]*ten;
                if(sum>(1L<<31)-1L)return -1;
                ten*=10;
            }
            res = (int)sum;
            break;
        }
        return res;
    }
}
// @lc code=end

