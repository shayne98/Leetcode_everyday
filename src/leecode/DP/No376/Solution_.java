package leecode.DP.No376;

/**
 * @author 小羊Shaun
 * @version 2.0
 * 376. Wiggle Subsequence
 * 用贪心去改进，dp只用一个isPositive根据上一次记录本次的趋势
 * nums[i]与nums[i-1]趋势符合时，也就是是非单调时max++
 * 趋势不符,根据贪心策略，取连续上升趋势中最大的，连续下降趋势中最小的，这样下一个元素符合趋势的可能性最大
 */
@SuppressWarnings("all")
public class Solution_ {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length,i=1;
        if(nums.length<=1)return len;
        //找到第一个前后不相等的元素
        while(nums[i]==nums[i-1]){
            i++;
            if(i==len)return 1;
        }
        //确定第一个趋势
        boolean isPositive = nums[i]-nums[i-1]>0?true:false;
        int max = 1;
        for(;i<len;i++){
            if(isPositive){
                //趋势符合递增
                if(nums[i]>nums[i-1]){
                    max++;
                    //下次趋势变化
                    isPositive = !isPositive;
                }
            }
            else if(!isPositive){
                if(nums[i]<nums[i-1]){
                    max++;
                    isPositive = !isPositive;
                }
            }
        }
        return max;
    }
}
