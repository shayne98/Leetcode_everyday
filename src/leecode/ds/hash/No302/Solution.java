package leecode.ds.hash.No302;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 303. Range Sum Query - Immutable
 * 前缀和
 */
class NumArray {
    int[] array;
    int[] sum;

    public NumArray(int[] nums) {
        array = nums;
        sum = new int[nums.length+1];
        for(int i=1;i<sum.length;i++){
            sum[i] = sum[i-1]+array[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right+1]-sum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */