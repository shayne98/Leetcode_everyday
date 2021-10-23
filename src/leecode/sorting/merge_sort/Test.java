package leecode.sorting.merge_sort;

import java.util.Arrays;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{5,6,4,8,9,1};
        int[] temp = new int[nums.length];
        new Test().merge_sort(nums,0,nums.length-1,temp);
        System.out.println(Arrays.toString(nums));

    }
    public void merge_sort(int[] nums,int l,int r,int[] temp){
        if(l>=r)return ;
        int m = l+(r-l)/2;
        merge_sort(nums,l,m,temp);
        merge_sort(nums,m+1,r,temp);
        int p = l;
        int q = m+1;
        int i =l;
        while(p<=m&&q<=r)temp[i++] = nums[p]>nums[q]?nums[q++]:nums[p++];
        while(p<=m)temp[i++] = nums[p++];
        while(q<=r)temp[i++] = nums[q++];
        for(i=l;i<=r;i++)nums[i]=temp[i];
    }
}
