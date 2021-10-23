package leecode.binarySearch.No81;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
public class Solution_ {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            if(low==high)return nums[low]==target;
            if(nums[low]==nums[high])low++;
            else {
                int mid = (low+high)/2;
                int temp = nums[mid];
                if(temp==target)return true;
                else if(temp<=nums[high]){
                    if(temp<target&&target<=nums[high])low = mid +1;
                    else high = mid - 1;
                }
                else{


                    if(temp>target&&target>nums[high])high = mid -1;
                    else low = mid+1;
                }
            }
        }
        return false;

    }
}
