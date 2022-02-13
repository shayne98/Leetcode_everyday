package leecode.ds.queue.No313;

import java.util.PriorityQueue;

/**
 * @author 小羊Shaun
 * @version 2.0
 * @date 2022/2/1 14:58
 */
public class Solution_ {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<primes.length;i++){
            q.add(new int[]{primes[i],primes[i],1});
        }
        for(int i=1;i<n;i++){
            res[i] = q.peek()[0];
            while(q.peek()[0]==res[i]){
                int[] temp = q.poll();
                int num = temp[1]*res[temp[2]];
                int prim = temp[1];
                int idx = temp[2]+1;
                q.add(new int[]{num,prim,idx});
            }
        }
        return res[n-1];


    }
}
