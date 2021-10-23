package leecode.greedy.No452;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]<o2[1])return-1;
                else return 1;
            }
        });
        int count=1;
        int last =points[0][1];
        for(int i=1;i< points.length;i++){
            if(points[i][0]>last){
                count++;
                last = points[i][1];
            }
        }
        return count;

    }
}