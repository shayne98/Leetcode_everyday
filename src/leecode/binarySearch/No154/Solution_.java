package leecode.binarySearch.No154;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution_ {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            if(low == high)return nums[low];
            if(nums[low]==nums[high])low++;
            else {
                int mid = (low+high)/2;
                int temp = nums[mid];
                if(temp<=nums[high])high =mid;
                else low = mid+1;
            }
        }
        return 0;

    }
}