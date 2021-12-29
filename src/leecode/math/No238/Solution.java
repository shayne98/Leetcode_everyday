package leecode.math.No238;

import java.util.Arrays;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 238. Product of Array Except Self
 * 不通过除法在O(n)的复杂度内记录除了该元素其他元素的乘积
 * 类似于分糖果的思路，从左到右遍历一遍，然后再从右往左遍历一遍，记录乘积product，先更新ans，再更新product
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans,1);
        int product = 1;
        for(int i=0;i<len;i++){
            ans[i] *= product;
            product *= nums[i];
        }
        product = 1;
        for(int i=len-1;i>=0;i--){
            ans[i] *= product;
            product *= nums[i];
        }
        return ans;

    }
}
