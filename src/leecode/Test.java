package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)return new int[]{-1,-1};
        int minIndex = findMin(nums,target);
        int maxIndex = findMax(nums,target);
        return new int[]{minIndex,maxIndex};
    }
    public int findMin(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] >=target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left<nums.length&&nums[left]==target?left:-1;
    }
    public int findMax(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] >target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return right>=0&&nums[right]==target?right:-1;
    }
}