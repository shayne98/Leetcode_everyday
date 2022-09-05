import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = nums[0]+nums[1]+nums[n-1];
        for(int i=0;i<nums.length-1;i++){
            int p = i+1,q = n-1;
            int resi = nums[p]+nums[q]+nums[i];
            boolean flag = resi>target;
            while(p<q){
                int tmp = nums[p]+nums[q]+nums[i];
                if(tmp ==target){
                    return tmp;
                }
                if(flag!=(tmp>target)){
                    flag=tmp>target;
                }
                if(Math.abs(target-tmp)<Math.abs(target-res)){
                    res = tmp;
                    
                }
                if(flag){
                    q--;
                }else{
                    p++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

