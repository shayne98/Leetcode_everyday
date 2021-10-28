package leecode.DP.No542;

import java.util.Arrays;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int width = mat[0].length;
        int height = mat.length;
        //先按左上到右下进行遍历一次，此时所有的点距离取左边和上边的最小值+1
        int[][] dp = new int[height][width];
        for (int[] ints : dp) {
            Arrays.fill(ints,Integer.MAX_VALUE-1);
        }
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(mat[i][j]==0){
                    dp[i][j]=0;
                }
                else{
                    if(i>0){
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+1);
                    }
                    if(j>0){
                        dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+1);
                    }
                }
            }
        }
        //从右下向左上进行一个遍历
        for(int i=height-1;i>=0;i--){
            for(int j=width-1;j>=0;j--){
                if(mat[i][j]!=0){

                    if(i<height-1){
                        dp[i][j]=Math.min(dp[i+1][j]+1,dp[i][j]);
                    }
                    if(j<width-1){
                        dp[i][j]=Math.min(dp[i][j+1]+1,dp[i][j]);
                    }
                }
            }
        }
        return dp;


    }
}