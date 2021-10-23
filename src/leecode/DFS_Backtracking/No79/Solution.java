package leecode.BFS_DFS.No79;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    int height,width;
    boolean visit[][];
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int len ;
    public boolean DFS(char[][] board, String word,int i,int j,int k){
        if(i<0||i>=height||j<0||j>=width||visit[i][j]==true||k>=len||board[i][j]!=word.charAt(k))return false;
        visit[i][j] = true;
        if(k==len-1){
            visit[i][j]=false;
            return true;
        }
        for (int[] ints : dir) {
            if(DFS(board,word,i+ints[0],j+ints[1],k+1)){
                visit[i][j]=false;
                return true;
            }
        }
        visit[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        height = board.length;
        width = board[0].length;
        len = word.length();
        visit = new boolean[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(DFS(board,word,i,j,0))return true;
            }
        }
        return false;
    }
}