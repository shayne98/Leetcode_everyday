package leecode.DP.No300;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 300. Longest Increasing Subsequence
 * 分割类动态规划
 * time O(n^2) | space O(n)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        //dp[i]是下标为i的元素作为末尾的子序列中最大的长度
        int[] dp  =new int[len];
        dp[0]=1;
        //Max用来记录所有子序列中最长的长度
        int Max =1;
        for(int i=1;i<len;i++){
            int temp = nums[i];
            int max=0;
            for(int j=i-1;j>=0;j--){
                //依次往前遍历找到末尾元素比nums[i]小的最长子序列
                if(nums[j]<temp&&dp[j]>max){
                    max = dp[j];
                }
                //更新dp[i]和Max
                dp[i]=max+1;
                Max = dp[i]>Max?dp[i]:Max;
            }
        }
        return Max;

    }
}
