package leecode.sorting.quick_sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{5,6,4,3,8,9};
        new Test().quick_sort1(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
        new Test().quick_sort2(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    //若把第一个作为基准
    public void quick_sort1(int[] nums,int l, int r){
        if(l>=r)return;
        int pivot = nums[l];
        int first = l;
        int last = r;
        while(first<last){
            while(first<last&&nums[last]>=pivot)last--;
            nums[first]=nums[last];
            while(first<last&&nums[first]<=pivot)first++;
            nums[last]=nums[first];
        }
        nums[first]= pivot;
        quick_sort1(nums,l,first-1);
        quick_sort1(nums,first+1,r);
    }
    //若把中间的点作为基准点
    public void quick_sort2(int[] nums,int l,int r){
        if(l>=r)return ;
        int pivot = nums[(l+r)/2];
        int first = l;
        int last = r;
        while(first<=last){
            while(first<=last&&nums[first]<pivot)first++;
            while(first<=last&&nums[last]>pivot)last--;
            if(first<=last){
                int temp =nums[first];
                nums[first] = nums[last];
                nums[last] = temp;
                first++;
                last--;
            }
        }
        quick_sort2(nums,l,last);
        quick_sort2(nums,first,r);
    }
}
