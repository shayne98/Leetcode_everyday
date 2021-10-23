package leecode.BFS.No934;

import java.util.LinkedList;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public static void main(String[] args) {
       int ans= new Solution().shortestBridge(new int[][]{{1, 1, 1, 1, 1},{1, 0, 0, 0, 1},{1, 0, 1, 0, 1},{1, 0, 0, 0, 1},{1, 1, 1, 1, 1}});
        System.out.println(ans);
    }
    int[][] matrix;
    int height;
    int width;
    LinkedList<int[]> queue = new LinkedList();
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestBridge(int[][] grid) {

        matrix = grid;
        height = grid.length;
        width = grid[0].length;
        boolean flag =false;
        //首先深搜确定标记一个岛屿的所有点，并且找出与岛屿相邻的点
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(matrix[i][j]==1) {
                    DFS(i, j);
                    flag = true;
                    break;
                }
            }
            if(flag)break;
        }
        while(!queue.isEmpty()){
            int[]temp = queue.getFirst();
            queue.pollFirst();
            for (int[] ints : dir) {
                int x = temp[0]+ints[0];
                int y = temp[1]+ints[1];
                if(x<0||x>=height||y<0||y>=width)continue;
                if(matrix[x][y]==1)return temp[2]+1;
                else if(matrix[x][y]==0) {
                    matrix[x][y]=2;
                    queue.addLast(new int[]{x,y,temp[2]+1});
                }
            }


        }
        return 0;


    }
    void DFS(int i,int j){
        matrix[i][j]=2;
        for (int[] ints : dir) {
            int x = i+ints[0];
            int y = j+ints[1];
            if(x<0||x>=height||y<0||y>=width)continue;
            if(matrix[x][y]==0){
                queue.addLast(new int[]{x,y,0});
                matrix[x][y]=2;
            }
            else if(matrix[x][y]==1)DFS(x,y);

        }

    }
}