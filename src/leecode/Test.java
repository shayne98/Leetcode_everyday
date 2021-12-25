package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")
class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int left =0,right = len-1;
        while(left<=right){
            //排除nums[mid]==num[left]但是在右边递增数组的情况
            if(nums[left]==nums[right]){
                left++;continue;
            }
            int mid = (left+right)/2;
            if(nums[mid]==target)return true;
                //说明mid左边是递增的
            if(nums[mid]>=nums[left]){
                //target不在递增数组的范围内，必在右边
                if(nums[mid]<target||target<nums[left])left = mid+1;
                else right = mid-1;
            }
            //因为数组中分为两个递增数组，mid肯定掉落在两个数组中,不在左边
            //说明mid位于右边的自增数组
            else {
                //不在递增数组的范围内，必在左边
                if(nums[mid]>target||nums[right]<target)right = mid-1;
                else left = mid+1;
            }

            }
        return false;

    }
}