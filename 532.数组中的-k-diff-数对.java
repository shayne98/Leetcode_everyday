import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=532 lang=java
 *
 * [532] 数组中的 k-diff 数对
 */

// @lc code=start
class Solution {
    public int findPairs(int[] nums, int k) {
        int res = 0,n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            int p = i+1,q=n-1;
            while(p<=q){
                if(p==q){
                    if(nums[p]-nums[i]==k)res++;
                    break;
                }
                int mid = (p+q)/2;
                if(nums[mid]-nums[i]==k){
                    res++;
                    break;

                }else if(nums[mid]-nums[i]>k){
                    q = mid-1;
                }else{
                    p = mid+1;

                }
            }

            


        }
        return res;


    }
}
// @lc code=end

