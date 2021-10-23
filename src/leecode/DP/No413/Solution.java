package leecode.DP.No413;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if(len<=2)return 0;
        int prev = nums[0]+nums[2]==2*nums[1]?1: 0;
        for(int i=3;i<len;i++){
            int num=0;
            int diff = nums[i]-nums[i-1];
            for(int j=i-1;j>0;j--){
                if(nums[j]-nums[j-1]!=diff)break;
                num++;
            }
             prev +=num;

        }
        return prev;

    }
}