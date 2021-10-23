package leecode.BFS_DFS.No46;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution {
    List<Integer> temp = new ArrayList<>();
    ArrayList ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        boolean[] visit = new boolean[len];
        for (int i = 0; i < len; i++) DFS(nums, visit, i);
        return ans;
    }

    public void DFS(int[] nums, boolean[] visit, int k) {
        visit[k] = true;
        Integer o = nums[k];
        temp.add(o);
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            temp.remove(o);
            visit[k] = false;
            return;
        }
        for (int i = 0; i < nums.length; i++)
            if(visit[i]==false)DFS(nums, visit, i);
        temp.remove(o);
        visit[k]=false;
        return ;

    }
}