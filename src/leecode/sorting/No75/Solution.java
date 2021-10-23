package leecode.sorting.No75;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution {
    public void sortColors(int[] nums) {
        int[] bucket = new int[3];
        for (int num : nums) bucket[num]++;
        int num=0;
        for(int i = 0;i<3;i++){
            for(int j=0;j<bucket[i];j++)nums[num++]=i;
        }
    }
}