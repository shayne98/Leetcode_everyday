package leecode.bitwise_operation.No136;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 136. Single Number
 * x^x =0;0^x =x;把所有的元素异或一遍结果就是单个的元素
 */
class Solution {
    public int singleNumber(int[] nums) {
        int ans =0;
        for(int i=0;i<nums.length;i++){
            ans ^= nums[i];
        }
        return ans;

    }
}