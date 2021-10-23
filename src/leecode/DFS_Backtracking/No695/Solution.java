package leecode.BFS_DFS.No695;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    int[][] matrix= new int[1][1];
    int width ;
    int height;
    boolean[][] flag;
    public int DFS(int i,int j){
        if(matrix[i][j]==0)return 0;
        int num1 = (judge(i+1,j)==true?DFS(i+1,j):0)+(judge(i-1,j)==true?DFS(i-1,j):0);
        int num2 = (judge(i,j+1)==true?DFS(i,j+1):0)+(judge(i,j-1)==true?DFS(i,j-1):0);
        return num1+num2+1;
    }
    public boolean judge(int i,int j){
        if(j<0||j>=width)return false;
        if(i<0||i>=height)return false;
        if(flag[i][j]==true||matrix[i][j]==0)return false;
        flag[i][j]=true;
        return true;
    }
    public int maxAreaOfIsland(int[][] grid) {
        matrix = grid;
        width = matrix[0].length;
        height = matrix.length;
        flag = new boolean[height][width];
        int max =0;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(flag[i][j]==false){
                    flag[i][j]=true;
                    if(i==3&&j==8){
                        int temp = DFS(i,j);
                        max = Math.max(max,temp);
                    }
                    else max = Math.max(max,DFS(i,j));
                }
            }
        }
        return max;
    }
}