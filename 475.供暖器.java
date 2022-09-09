import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=475 lang=java
 *
 * [475] 供暖器
 */

// @lc code=start
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        //反向思维，对于houses中的每个位置，
        //若要被取暖，找到最小的取热半径
        //结果是所有取热半径最大值
        int res =0,n = heaters.length;
        //需要对heaters数组进行sort
        Arrays.sort(heaters);
        for(int pos:houses){
            if(pos<=heaters[0]){
                res = Math.max(res,heaters[0]-pos);
            }else if(pos>=heaters[n-1]){
                res = Math.max(res, pos-heaters[n-1]);
            }else{
                
                int i=0,j=heaters.length-1;
                int temp = pos-heaters[0];
                //找到距离pos最近的位置，可以用二分法查找
                while(i<=j){
                    if(i==j){
                        temp = Math.min(temp, Math.abs(heaters[i]-pos));
                        break;
                    }
                    int mid = (i+j)/2;
                    if(heaters[mid]==pos){
                        temp = 0;
                        break;
                    }else if(heaters[mid]>pos){
                        //mid在右边
                        temp = Math.min(temp,heaters[mid]-pos);
                        j = mid;
                    }else{
                        //mid在左边
                        temp = Math.min(temp, pos-heaters[mid]);
                        i = mid+1 ;
                    }

                }
                res = Math.max(res,temp);

            }

        }
        return res;
    }
}
// @lc code=end

