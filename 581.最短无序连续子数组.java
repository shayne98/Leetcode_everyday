/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        //等价于
        int n = nums.length;
        int[] beforeMax = new int[n];
        int[] afterMin = new int[n];
        int tempMax = nums[0],tempMin = nums[n-1];
        for(int i=0;i<n;i++){
            if(tempMax<nums[i]){
                beforeMax[i]=nums[i];
                tempMax = nums[i];
            }
            else{
                beforeMax[i] = tempMax;
            }
            if(tempMin>nums[n-i-1]){
                afterMin[n-i-1]=nums[n-i-1];
                tempMin = nums[n-i-1];
            }else{
                afterMin[n-i-1] = tempMin;
            }

        } 
        int i=0,j=n-1;
        while(i<n&&nums[i]<=afterMin[i])i++;
        while(j>=i&&nums[j]>=beforeMax[j])j--;
        return j-i+1;

    }
}
// @lc code=end

