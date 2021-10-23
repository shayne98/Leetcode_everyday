package leecode.twoPointers.No633;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        long start =0;
        long end = (long)Math.sqrt(c);
        while(start<end){
            long sum = start*start+end*end;
            if(sum==c)return true;
            else if(sum<c)start++;
            else end--;
        }
        return false;

    }
}
