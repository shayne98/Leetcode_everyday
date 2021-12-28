package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int left =0;
        int right = len-1;
        while(left<=right){
            if(left == right ){
                return nums[left];
            }
            int mid = (left + right)/2;
            if(mid%2==1){
                //若mid左右有奇数个元素
                if(nums[mid] == nums[mid+1]){
                    //mid属于右边的堆，左边堆就是奇数个元素
                    //单个元素必在左边
                    right = mid-1;
                }
                else{
                    //mid不属于右边堆，那么右边堆只有奇数个元素
                    left = mid+1;
                }

            }
            else{
                //mid左右有偶数个元素
                if(nums[mid] == nums[mid+1]){
                    //mid属于右边的那堆，单个元素必存在奇数堆中
                    left = mid+2;
                }
                else{
                    //mid属于左边那堆
                    right = mid;
                }
            }
        }
        return 0;

    }
}