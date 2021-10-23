package leecode.binarySearch.No4;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution {
    //    public static void main(String[] args) {
//        int[] nums1 =new int[]{1,2};
//        int[] nums2 =new int[]{3,4};
//        System.out.println(new Solution().findMedianSortedArrays(nums1,nums2));
//    }

    /**
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return 返回nums1和nums2混合后数组的第k个元素
     */
    public int findK(int[] nums1,int[] nums2,int k){
        int p1=0;
        int p2=0;
        while(k>=1){
            int temp = k/2;
            //若其中一个数组已空直接返回另一个数组中的对应元素即可
            if(p1>=nums1.length)return nums2[p2+k-1];
            if(p2>=nums2.length)return nums1[p1+k-1];
            //k==1时返回两个数组p1\p2分别指向的元素中的较小值
            if(k==1)return Math.min(nums1[p1],nums2[p2]);
            //若p1后的元素少于k的一半，则混合后第k个元素必定不在nums2的前k/2个元素中
            if(p1+temp>nums1.length)p2+=temp;
            else{
                //nums1中p1后k/2个元素比num2中对应的元素小，那么nums1中p1后k/2必定不包含混合后的第K个元素
                if(nums1[p1+temp-1]<=nums2[p2+temp-1])p1+=temp;
                else p2+=temp;
            }
            k-=temp;
        }
        return 0;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //不妨使得nums1长度小于nums2的长度
        if(m>n){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        //为避免分类讨论，取混合数组的midleft和midright的平均值一定是要求的结果，无论奇偶
        int midLeft = findK(nums1,nums2,(m+n+1)/2);
        int midRight = findK(nums1,nums2,(m+n+2)/2);
        return (midLeft+midRight)/2.0;


    }
}