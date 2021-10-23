package leecode.BFS_DFS.No547;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    int n ;
    boolean flag[];
    public void BFS(int[][] isConnected,int i){
        flag[i]=true;
        for(int k=0;k<n;k++)
            if(isConnected[i][k]==1&&flag[k]==false)BFS(isConnected,k);
    }
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        flag = new boolean[n];
        int cnt = 0;
        for(int i=0;i<n;i++)
            if(flag[i]==false){
                cnt++;BFS(isConnected,i);
            }
        return cnt;
    }
}