package leecode.DP.No221;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public static void main(String[] args) {
        char[][] matrix = new char[][]
                {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        new Solution().maximalSquare(matrix);
    }
    public int maximalSquare(char[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        int[][] dp = new int[height][width];
        int max=0;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }
                else {
                    if(i>0&&j>0){
                        dp[i][j]=Integer.MAX_VALUE-1;
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]+1);
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+1);
                        dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+1);
                    }
                    else {
                        dp[i][j]=1;
                    }
                    max = max<dp[i][j]? dp[i][j]:max;
                }

            }
        }
        return max*max;

    }
}