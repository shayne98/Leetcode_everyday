import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=519 lang=java
 *
 * [519] 随机翻转矩阵
 */

// @lc code=start
class Solution {
    Set<Integer> ids ;
    int rows,cols;
    Random r = new Random(300);
    public Solution(int m, int n) {
        ids = new HashSet<>();
        rows = m;
        cols = n;

    }
    
    public int[] flip() {
        int n = ids.size();
        int id = r.nextInt(rows*cols);
            int i=id,j=id;
            while(i>=0&&ids.contains(i))i--;
            while(j<n&&ids.contains(j))j++;
            int res = i>=0&&!ids.contains(i)?i:j;
            ids.add(res);
            return new int[]{res/cols,res%cols};
    }
    
    public void reset() {
        ids.clear();




    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
// @lc code=end

