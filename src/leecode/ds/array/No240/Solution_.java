package leecode.ds.array.No240;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 240. Search a 2D Matrix II
 * 在行、列有序的二维数组中寻找元素的技巧
 */
class Solution_ {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i=0,j=n-1;
        while(j>=0&&i<m){
            if(target==matrix[i][j])return true;
            if(target>matrix[i][j])i++;
            else j--;
        }
        return false;
    }
}