/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1,p2 = n-1,q = n+m-1;
        while(p2>=0&&p1>=0){
            int min = Math.max(nums1[p1], nums2[p2]);
            if(nums1[p1]>=nums2[p2]){
                p1--;
            }else{
                p2--;
            }
            nums1[q--] = min;
        }
        while(p2>=0){
            nums1[q--] = nums2[p2--];
        }


    }
}
// @lc code=end

