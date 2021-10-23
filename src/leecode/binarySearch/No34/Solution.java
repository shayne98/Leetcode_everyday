package leecode.binarySearch.No34;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
//    public static void main(String[] args) {
//        //Input: nums = [5,7,7,8,8,10], target = 8
//        //Output: [3,4]
//        int[] nums = new int[]{5,7,7,8,8,10};
//       int[] ans = new Solution().searchRange(nums,8);
//        System.out.println("["+ans[0]+", "+ans[1]+"]");
//    }
    //O(logn) time |O(logn) space
    public int startIndex(int[] nums, int target, int l, int r) {
        int mid = (l + r) / 2;
        if (l > r) return nums.length;
        if (nums[mid] == target) return Math.min(mid, startIndex(nums, target, l, mid - 1));
        else if (nums[mid] > target) return startIndex(nums, target, l, mid - 1);
        else return startIndex(nums, target, mid + 1, r);
    }
    public int endIndex(int[] nums, int target, int l, int r) {
        int mid = (l + r) / 2;
        if (l > r) return -1;
        if (nums[mid] == target) return Math.max(mid, endIndex(nums, target, mid+1, r));
        else if (nums[mid] > target) return endIndex(nums, target, l, mid - 1);
        else return endIndex(nums, target, mid + 1, r);
    }

    public int[] searchRange(int[] nums, int target) {
        int start = startIndex(nums,target,0,nums.length-1);
        int end = endIndex(nums,target,0,nums.length-1);
        if(start==nums.length)start=-1;
        return new int[]{start,end};

    }
}