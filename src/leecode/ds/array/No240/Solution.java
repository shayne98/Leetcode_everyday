package leecode.ds.array.No240;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i;
        if(target<matrix[0][0]||target>matrix[m-1][n-1])return false;
        for(i=0;i<m;i++){
            int left = 0,right=n-1;
            while(left<=right){
                if(left==right){
                    if(target==matrix[i][left])return true;
                    else break;
                }
                int mid = (left+right)/2;
                if(matrix[i][mid]==target)return true;
                if(target>matrix[i][mid])left = mid+1;
                else right = mid-1;
            }
        }
        return false;
    }
}