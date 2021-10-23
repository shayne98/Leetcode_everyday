package leecode.binarySearch.No81;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public boolean findTarget(int l, int r,int[]nums, int target){
        int low =l;
        int high = r;
        while(low<=high){
            int mid = (low+high)/2;
            int temp = nums[mid];
            if(temp==target)return true;
            else if(temp<target)low = mid+1;
            else high = mid -1;
        }
        return false;
    }
    public boolean search(int[] nums, int target) {
        //先找到第一组最后元素
        int last=0;
        for(int i=1;i<nums.length;i++){
            int temp = nums[i];
            if(temp==target)return true;
            if(nums[last]>temp)break;
            last = i;
        }
        //分为两段进行二分查找
        if(findTarget(0,last,nums,target)==true)return true;
        else if(last<nums.length-1&&findTarget(last+1,nums.length-1,nums,target)==true)return true;
        else return false;



    }
}