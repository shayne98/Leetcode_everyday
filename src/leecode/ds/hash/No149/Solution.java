package leecode.ds.hash.No149;

import java.util.HashMap;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public int maxPoints(int[][] points) {
        int maxSame =1;
        for(int i=0;i<points.length;i++){
            HashMap<Double,Integer> map = new HashMap<>();
            int samePoint=1,zeroRate = 0;
            int x1 = points[i][0],y1 = points[i][1];
            for(int j=i+1;j<points.length;j++){
                int x2 = points[j][0],y2 = points[j][1];
                if(x1==x2){
                    if(y1==y2){
                        samePoint++;
                        maxSame++;
                    }
                    else{
                        zeroRate++;
                        maxSame = Math.max(maxSame,samePoint+zeroRate);
                    }
                }
                else{
                    Double rate = 1.0*(y2-y1)/(x2-x1)+0.0;
                    if(map.containsKey(rate)){
                        map.put(rate,map.get(rate)+1);
                    }
                    else{
                        map.put(rate,1);
                    }
                    maxSame = Math.max(maxSame,map.get(rate)+samePoint);
                }
            }
        }
        return maxSame;

    }
}