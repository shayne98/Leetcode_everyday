package leecode.DFS_Backtracking.No417;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
public class Solution_ {
}
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
                DFS(i,0,heights,PacVisit);
            }
            //右
            if(AltVisit[i][width-1]==false){
                DFS(i,width-1,heights,AltVisit);
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
                if(AltVisit[i][j]&&PacVisit[i][j]){
                    ArrayList<Integer> temp =new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
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