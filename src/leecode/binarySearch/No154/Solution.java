package leecode.binarySearch.No154;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution {
    //O(logn) time |O(1) space
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            //low和high为下标的数组元素相等时，此时mid再和high对应的元素相等时无法判断起点位置，需要单独处理
            while(low<high&&nums[low]==nums[high])low++;
            //只有一个值时返回
            if(low==high)return nums[low];
            int mid = (low+high)/2;
            int temp = nums[mid];
            //temp比high对应的值大，起点必在mid的右边
            if(temp>nums[high]){
                low = mid+1;
            }
            //temp小于等于high对应的值，起点在mid或者mid的左边
            else {
                high = mid;
            }
        }
        return nums[high];

    }
}