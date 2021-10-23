package leecode.BFS_DFS.No77;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    List<List<Integer>> ans =new ArrayList<>();
    boolean[] visit;
    public void DFS(int n, int k, ArrayList temp,int prev){

        //使得后面添加的元素一定比前面的大，这样就避免了重复添加同一组合的情况
        //若后面剩余的元素不到k个直接返回，剪枝减小时间复杂度
        for(int i=prev+1;i<=n-k+1;i++){
            if(visit[i]==false){
                visit[i]= true;
                temp.add(i);
                if(k==1)ans.add(new ArrayList<>(temp));
                else DFS(n,k-1,temp,i);
                temp.remove((Object) i);
                visit[i]=false;
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        ArrayList temp = new ArrayList();
        visit = new boolean[n+1];
        DFS(n,k,temp,0);
        return ans;
    }
}