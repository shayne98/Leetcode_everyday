package leecode.binarySearch.No69;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public int mySqrt(int x) {
        long low = 0;
        long high = x;
        while(low<high){
            long mid = (low+high)/2;
            long mul = mid *mid;
            if(mul== x)return (int)mid;
            else if(mul>x)high =mid-1;
            else low = mid+1;
        }
        return (int)high;
    }
}