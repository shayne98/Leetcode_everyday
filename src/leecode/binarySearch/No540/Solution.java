package leecode.binarySearch.No540;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0;
        int high = nums.length-1;
        while(low<=high){
            //只有一个值直接返回
            if(low==high)return nums[low];
            int mid = (low+high)/2;
            //num[mid]和左右的值都不同，说明nums[mid]就是所求的
            if(nums[mid-1]!=nums[mid]&&nums[mid+1]!=nums[mid])return nums[mid];
            else{
                //nums[mid]和左边的值相等时
                if(nums[mid-1]==nums[mid]){
                    //mid右边元素个数是奇数，单个数必在右边
                    if(mid%2==1)low = mid+1;
                    //mid及其左边元素个数是计数，单个数必在左边
                    else high = mid;
                }
                //nums[mid]和右边的值相等同理
                else{
                    if(mid%2==1)high =mid-1;
                    else low =mid;
                }
            }
        }
        return nums[high];

    }
}