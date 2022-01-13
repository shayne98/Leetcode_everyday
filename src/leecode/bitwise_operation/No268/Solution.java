package leecode.bitwise_operation.No268;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No268 Missing Number
 * like No136
 */
class Solution {
    public int missingNumber(int[] nums) {
        int num = 0;
        for(int i=0;i<nums.length;i++){
            num^=i;
            num^=nums[i];
        }
        num^= nums.length;
        return num;
    }

}