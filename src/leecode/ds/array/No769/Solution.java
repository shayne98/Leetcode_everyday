package leecode.ds.array.No769;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 769. Max Chunks To Make Sorted
 * 题目等价于找到最小的k使得A[:k+1]包含0~k的所有元素
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = arr[0];
        int rest = arr[0];
        int res =1;
        for(int i=1;i<arr.length;i++){
            if(rest==0){
                rest = arr[i]-max-1;
                max = arr[i];
                res++;

            }
            else if(arr[i]<max){
                rest--;
            }
            else{
                rest+=arr[i]-max-1;
                max = arr[i];
            }
        }
        return res;

    }
}