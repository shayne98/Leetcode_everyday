package leecode.BFS_DFS.No417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution {
    int height;
    int width;
    int[][] dir = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights){
        List<List<Integer>> ans = new ArrayList<>();
        height = heights.length;
        width = heights[0].length;
        int i,j;
        boolean[][] pac = new boolean[height][width];
        boolean[][] atl = new boolean[height][width];
        for(i=0;i<height;i++){
            DFS(heights,pac,i,0,0);
            DFS(heights,atl,i,width-1,0);
        }
        for(i=0;i<width;i++){
            DFS(heights,atl,height-1,i,0);
            DFS(heights,pac,0,i,0);
        }
        for(i=0;i<height;i++)
            for(j=0;j<width;j++)
                if(pac[i][j]&&atl[i][j])ans.add(new ArrayList<>(Arrays.asList(i,j)) );
        return ans;
    }
    public void DFS(int[][] heights,boolean visit[][], int i, int j, int prev) {
        if(i<0||i>=height||j<0||j>=width||visit[i][j]||heights[i][j]<prev)return;
        visit[i][j] = true;
        for (int[] ints : dir) DFS(heights,visit,i+ints[0],j+ints[1],heights[i][j]);
    }
}

