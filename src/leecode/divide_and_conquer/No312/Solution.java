package leecode.divide_and_conquer.No312;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No312. Burst Balloons
 * 分治的依据是最后一个爆炸的元素为界
 * 因为分治后的结果需要使用分治前的元素，所以需要构造比给定数组左右各多一个空位用于储存爆炸后左右位置的元素
 */
class Solution {
    int[][] memo;
    public int maxCoins(int[] nums) {
        int len = nums.length;
        memo = new int[len+2][len+2];
        //首位各多设一位用于储存当前数列最后一个爆炸时的左右位置的元素
        int[] Nums = new int[len + 2];
        //初始首尾记为1因为最后一个爆炸是两边没有数字默认为1
        Nums[0]=1;
        int t=1;
        for (int num : nums) {
            Nums[t++]=num;
        }
        Nums[t++]=1;
        return DFS(Nums,0,len+1);
    }
    public int DFS(int[] nums,int left,int right){
        int ans = 0;
        //真正的数列是在left到right之间的，left+1==right说明已经全部爆炸完了
        if(left+1==right)
            return 0;
        //用memo来记录已经出现过的情况
        else if(memo[left][right]>0){
            return memo[left][right];
        }
        else{
            //用当前left到right之间的元素中最后一个爆炸的元素作为分治的依据，分割依次遍历
            //取其中最大的作为left和right位爆炸前最后一个爆炸的元素
            for(int i=left+1;i<right;i++){
                ans = Math.max(ans,nums[i]*nums[left]*nums[right]+DFS(nums,left,i)+DFS(nums,i,right));
            }
        }
        memo[left][right] = ans;
        return ans;
    }
}