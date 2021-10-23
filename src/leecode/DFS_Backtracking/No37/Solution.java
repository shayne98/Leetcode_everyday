package leecode.DFS_Backtracking.No37;

import java.util.concurrent.ConcurrentNavigableMap;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'.','.','6','.','.','.','.','.','.'},
                {'.','.','7','2','.','.','.','4','.'},
                {'.','5','.','.','4','3','.','.','.'},
                {'.','.','.','.','7','4','.','.','.'},
                {'8','.','.','9','.','.','.','.','.'},
                {'.','.','.','.','.','8','7','5','.'},
                {'.','.','2','.','.','5','.','.','9'},
                {'.','.','.','.','9','2','8','6','.'},
                {'.','.','3','.','.','6','1','.','.'}};
        new Solution().solveSudoku(board);
        for(int i=0;i<9;i++){
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    //判断小方块
    boolean[][] cell = new boolean[9][10];
    //判断行
    boolean[][] row = new boolean[9][10];
    //判断列
    boolean[][] column = new boolean[9][10];


    public void solveSudoku(char[][] board) {
        //先把预留数字的情况记录在三个判断boolean数组中
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')continue;
                int temp = board[i][j]-'0';
                row[i][temp]=true;
                column[j][temp]=true;
                cell[i/3*3+j/3][temp]=true;
            }
        }
        DFS(0,0,board);
    }
    boolean DFS(int m,int n,char[][] board){
        //遍历m,n坐标以及以后的点位
        for(int i=m;i<9;i++,n=0){
            for(int j=n;j<9;j++){
                if(board[i][j]!='.') continue;
                //遇到·进行填充数字的判断
                for(char ch='1';ch<='9';ch++){
                    int temp = ch-'0';
                    if(row[i][temp]||column[j][temp]||cell[i/3*3+j/3][temp])continue;
                    board[i][j]=ch;
                    row[i][temp]=true;
                    column[j][temp]=true;
                    cell[i/3*3+j/3][temp]=true;
                    //剩下的每个小格满足要求，则返回true
                    if(DFS(i,j,board))return true;
                    //若没有，重置该数字的判断数组，换一个数字，再试
                    row[i][temp]=false;
                    column[j][temp]=false;
                    cell[i/3*3+j/3][temp]=false;
                }
                //所有的数字都不满足，说明i,j之前的小格子选值有问题，还原i,j坐标原来的值，返回false
                board[i][j]='.';
                return false;
            }

        }
        //遍历结束跳出的循环应该返回true
        return true;

    }
}