package leecode.ds.queue.No218;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        //记录高度改变时的第一个点的坐标
        int len = buildings.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> infos = new ArrayList<>();
        for (int[] building : buildings) {
            infos.add(new int[]{building[0],-1*building[2]});
            infos.add(new int[]{building[1],building[2]});
        }
        //按坐标进行排序，从小到大，先x再看y
        Collections.sort(infos,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        int prev = 0;
        pq.add(0);
        for (int[] info : infos) {
            if(info[1]<0){
                pq.offer(-1*info[1]);
            }
            else{
                pq.remove(info[1]);
            }
            int curMax = pq.peek();
            if(prev!=curMax){
                List<Integer> temp = new ArrayList<>();
                temp.add(info[0]);
                temp.add(curMax);
                ans.add(temp);
                prev = curMax;
            }

        }
        return ans;
    }
}
