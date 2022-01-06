package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n=nums2.length;
        int midleft = findK(nums1,nums2,(m+n+1)/2);
        int midright = findK(nums1,nums2,(m+n+2)/2);
        return (midleft+midright)/2.0;

    }
    public int findK(int[] nums1,int[] nums2,int k){
        //找到nums1和nums2合并后第k个数
        int p1=0,p2=0;
        int len1 = nums1.length,len2 = nums2.length;
        while(k>0){
            int temp = k/2;
            if(p1>=len1){
                return nums2[p2+k-1];
            }
            if(p2>=len2){
                return nums1[p1+k-1];
            }
            if(k==1)return Math.min(nums1[p1],nums2[p2]);
            if(p1+temp-1>=len1){
                //nums2中前k/2个必定不存在第k个数
                p2+=temp;
            }
            else if(p2+temp-1>=len2){
                p1+=temp;
            }
            else if(nums1[p1+temp-1]>nums2[p2+temp-1]){
                p2+=temp;
            }
            else{
                p1+=temp;
            }
            k-=temp;
        }
        return 0;
    }
}