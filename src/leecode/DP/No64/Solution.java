package leecode.DP.No64;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public static void main(String[] args) {
        int [][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new Solution().minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        //记录上一行的数据
        int[] prev_row = new int[width];
        for(int i=0;i<height;i++){
            //每一行的第一个元素没有左边的元素需要单独处理
            prev_row[0]+=grid[i][0];
            for (int j = 1; j < width; j++)
                //三元运算符注意加（）
                //因为第一行的元素没有上一行，需要单独处理
                prev_row[j]=(i==0?prev_row[j-1]:Math.min(prev_row[j-1],prev_row[j]))+grid[i][j];
        }
        return prev_row[width-1];
    }
}