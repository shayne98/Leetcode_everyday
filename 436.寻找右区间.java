import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=436 lang=java
 *
 * [436] 寻找右区间
 */

// @lc code=start
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] clone = new int[n][3];
        for(int i=0;i<n;i++){
            clone[i] = new int[3];
            clone[i][0] = i;
            clone[i][1] = intervals[i][0];
            clone[i][2] = intervals[i][1];
        }
        Arrays.sort(clone, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i=0;i<n;i++){
            int j = i,k = n-1;
            // while(j<n&&clone[j][1]<clone[i][2])j++;
            //二分法找到第一个clone[j][1]>=clone[i][2]的j
            while(j<k){
                int mid = (j+k)/2;
                if(clone[mid][1]==clone[i][2]){
                    j=mid;
                    break;
                }else if(clone[mid][1]>clone[i][2]){
                    k = mid;
                }else{
                    j = mid+1;
                }
            }
            if(j<n&&clone[j][1]>=clone[i][2]){
                res[clone[i][0]] = clone[j][0];
            }
        }
        return res;

    }
}
// @lc code=end

