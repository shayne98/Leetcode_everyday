package leecode.DP.No300;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 小羊Shaun
 * @version 2.0
 * 300. Longest Increasing Subsequence
 * 分割类动态规划，采用贪心算法和二分查找进行优化
 * time O(nlongn) | space O(n)
 *
 * 室友的提醒下，发现答案给的二分贪心做法我的理解有点问题的，虽然返回的序列长度是对的
 * 但是dp这个arraylist内部存的序列可能是不满足条件的，也就是说储存的并不是当前情况下的最长子序列
 *例如[10,9,2,5,3,1,101,18]，依次处理过程中，dp中储存的分别是：
 *{10}{9}{2}{2，5}{2，3}{1，3}到此位置序列已经不满足题意了，1的位置在3的位置前，源数组1的位置在3之后，
 * 由于dp的长度不减，而某个长度的dp必定对应一个符合题意的子序列，但可能不是当前的子序列
 *
 */
class Solution_{
//    public static void main(String[] args) {
//        int[] nums = new int[]{10,9,2,5,3,7,101,18};
//        System.out.println(new Solution_().lengthOfLIS(nums));
//    }
    public int lengthOfLIS(int[] nums) {
        //dp用来记录当前的最长子序列元素
        ArrayList<Integer> dp = new ArrayList<>();
        int len = nums.length;
        dp.add(Integer.valueOf(nums[0]));
        for(int i=1;i<len;i++){
            int temp = nums[i];
            int index = Collections.binarySearch(dp,temp);
            /**
             *  如果搜索键包含在列表中，则返回搜索键的索引；否则返回 (-(插入点) - 1)。
             *  插入点 被定义为将键插入列表的那一点,即第一个大于此键的元素索引；
             */
            //因为题目是严格单调递增所以只记录不存在的情况下
            if(index<0){
                index = -1*index-1;
                //若nums[i]大于dp中的所有元素，则将nums[i]加到末尾即可
                if(index==dp.size())
                    dp.add(Integer.valueOf(nums[i]));
                //若nums[i]小于dp中index为下标的元素，改其改为nums[i]这样后面遍历元素时组成递增序列的可能性增加了
                //这是一种贪心的思想
                //同时保证dp永远是递增的序列
                else{
                    dp.set(index,Integer.valueOf(nums[i]));
                }

            }

        }
        return dp.size();

    }
}