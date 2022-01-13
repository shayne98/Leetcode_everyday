package leecode.bitwise_operation.No260;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No260 Single Number Ⅲ
 * 当出现两个单个数时怎么把数组分成两部分，将两个单个数分别放在两个部分中然后再用异或分别对两部分进行
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int i=0;i<nums.length;i++){
            diff^=nums[i];
        }
        int m =1;
        while((diff&m)==0)
            m<<=1;
        int num1=0,num2=0;
        for(int i=0;i<nums.length;i++){
            num1^=(nums[i]&m)==0?0:nums[i];
            num2^=(nums[i]&m)==0?nums[i]:0;
        }
        return new int[]{num1,num2};
    }
}