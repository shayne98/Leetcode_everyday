package leecode.BFS_DFS.No51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 小羊Shaun
 * @version 1.0
 */

class Solution_ {
    void dfs(LinkedList<String> path, int idx, boolean[] col, boolean[] diag1, boolean[] diag2) {
        if (idx>=n)
            ans.add(new ArrayList<>(path));
        else {
            char[] sb = new char[n];
            Arrays.fill(sb, '.');
            for (int i=0, j=n-1; i<n; i++, j--) {
                int d1 = i+idx, d2 = j+idx;
                if (!col[i] && !diag1[d1] && !diag2[d2]) {
                    col[i] = true;
                    diag1[d1] = true;
                    diag2[d2] = true;
                    sb[i]='Q';
                    path.addLast(String.copyValueOf(sb));
                    dfs(path, idx+1, col, diag1, diag2);
                    path.pollLast();
                    sb[i]='.';
                    col[i] = false;
                    diag1[d1] = false;
                    diag2[d2] = false;
                }
            }
        }
    }

    List<List<String>> ans = new ArrayList<>();
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        LinkedList<String> path = new LinkedList<>();
        dfs(path, 0, new boolean[n], new boolean[n*2-1], new boolean[n*2-1]);
        return ans;
    }
}