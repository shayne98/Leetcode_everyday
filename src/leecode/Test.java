package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")

class Solution {
    boolean[][] PacVisit,AltVisit;
    List<List<Integer>> ans = new ArrayList<>();
    int height,width;
    int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        height =heights.length;
        width = heights[0].length;
        PacVisit = new boolean[height][width];
        AltVisit = new boolean[height][width];
        for(int i=0;i<height;i++){
            //左
            if(PacVisit[i][0]==false){
                DFS(i,0,heights,AltVisit);
            }
            //右
            if(AltVisit[i][width-1]==false){
                DFS(i,width-1,heights,PacVisit);
            }
        }
        for(int j=0;j<width;j++){
            //下
            if(AltVisit[height-1][j]==false)
                DFS(height-1,j,heights,AltVisit);
            //上
            if(PacVisit[0][j]==false)
                DFS(0,j,heights,PacVisit);
        }
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(!AltVisit[i][j]&&PacVisit[i][j]){
                    ans.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return ans;
    }
    public void DFS(int i,int j,int[][] heights,boolean[][] visit){
        visit[i][j]=true;
        for (int[] ints : dir) {
            int x =i+ints[0];
            int y = j+ints[1];
            if(x<0||x>=height||y<0||y>=width||visit[x][y]||heights[x][y]<heights[i][j])continue;
            DFS(x,y,heights,visit);
        }
    }
}