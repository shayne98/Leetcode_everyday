package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")
class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = nums.length-1;
        int min = nums[0];
        while(left<=right){
            if(left == right)return Math.min(nums[left],min);
            if(nums[left]==nums[right]){
                left++;
                continue;
            }
            int mid = (left+right)/2;
            if(nums[mid]>=nums[left]){
                //说明左边是递增数组
                min = Math.min(nums[left],min);
                left = mid +1;
            }
            else{
                //右边是递增数组
                min = Math.min(nums[mid],min);
                right = mid-1;
            }
        }
        return  min;

    }
}