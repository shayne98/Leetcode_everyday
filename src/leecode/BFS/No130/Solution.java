package leecode.BFS.No130;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public void solve(char[][] board) {
        int[][] dir = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        int height = board.length;
        int width = board[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        //标记外围的字符O必然不能被围起来来
        //并入队
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if((i==0||j==0||i==height-1||j==width-1)&&board[i][j]=='O'){
                    board[i][j]='#';
                    q.addLast(new int[]{i,j});
                }
            }
        }
        //BFS找到外围字符O相连的所有字符O，全部标记为'#'，不能被围起来
        while(!q.isEmpty()){
            int[] top = q.pollFirst();
            for (int[] ints : dir) {
                int x = top[0]+ints[0];
                int y = top[1]+ints[1];
                if(x<0||x>=height||y<0||y>=width||board[x][y]!='O')continue;
                board[x][y]='#';
                q.addLast(new int[]{x,y});
            }

        }
        //将所有的O字符变为X字符
        //所有的#字符变成'O'
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(board[i][j]=='O')board[i][j]='X';
                else if(board[i][j]=='#')board[i][j]='O';
            }
        }


    }
}