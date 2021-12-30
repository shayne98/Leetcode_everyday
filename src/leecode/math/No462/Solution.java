package leecode.math.No462;

import java.util.Arrays;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 462. Minimum Moves to Equal Array Elements II
 * 类似于求|x-1|+|x-2|+...+||x-n|的最小值
 * 这题的思考方法是基准值从序列的最小值开始，慢慢往上增长，只要序列中比基准值小的个数小于比基准值大的个数，
 * 那么在基准值增长的过程，总的移动次数就是在减少的，直到达到序列的中位数，
 * 对于奇数序列长度，中位数只有一个
 * 对于偶数序列长度，中位数取[leftMedian,rightMedian]即可
 * 记中位数值为为C，将序列排序后，总的移动次数就是
 * move = C-nums[0]+C-nums[1]+……+C-nums[mid-1]+nums[mid+1]-C+...+nums[nums.length-1]-C
 * 不妨中位数记为nums.length/2下标的值，奇数长度数组中C全部抵消,偶数长度多一个C
 * time O(nlogn) |space O(1)
 */
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums.length/2;
        int move = nums.length%2==0?nums[median]:0;
        for(int i=0;i<median;i++){
            move -= nums[i];
        }
        for(int i=median+1;i<nums.length;i++){
            move += nums[i];
        }
        return move;

    }
}