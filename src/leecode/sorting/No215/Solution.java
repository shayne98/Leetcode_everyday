package leecode.sorting.No215;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public int quick_sort(int[] nums,int l,int r,int k){
        if(l==r)return nums[l];
        int pivot = nums[(r+l)/2];
        int first = l;
        int last = r;
        while(first<=last){
            while(first<=last&&nums[last]>pivot)last--;
            while(first<=last&&nums[first]<pivot)first++;
            if(first<=last){swap(nums,first,last);first++;last--;}
        }
        if(first<=k)return quick_sort(nums,first,r,k);
        else if(k<=last)return quick_sort(nums,l,last,k);
        else return pivot;


    }
    public void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    public int findKthLargest(int[] nums, int k) {
        return quick_sort(nums,0,nums.length-1,nums.length-k);
    }
}