package leecode.greedy.No435;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int eraseCount=0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {//重写的compare函数注意-1，0，1三种情况都要存在
                if(o1[1]<o2[1])return -1;
                else if(o1[1]==o2[1])return 0;
                else return 1;
            }
        });
        int last=intervals[0][0];
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<last)eraseCount++;
            else last=intervals[i][1];
        }
        return eraseCount;


    }
}
