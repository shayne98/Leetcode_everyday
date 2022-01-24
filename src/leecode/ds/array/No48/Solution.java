package leecode.ds.array.No48;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        for(int i=0;i<=(n-1)/2;i++){
            for(int j=i;j<n-i-1;j++){
                int first = matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = first;
            }
        }
    }
}