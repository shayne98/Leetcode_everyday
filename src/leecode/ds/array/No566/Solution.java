package leecode.ds.array.No566;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 566. Reshape the Matrix
 */
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int height = mat.length;
        int width = mat[0].length;
        if(r*c!=height*width)return mat;
        int[][] res = new int[r][c];
        int i=0,j=0;
        for(int[] nums:mat){
            for(int num: nums){
                res[i][j++] = num;
                if(j==c){
                    i++;j=0;
                }
            }
        }
        return res;

    }
}