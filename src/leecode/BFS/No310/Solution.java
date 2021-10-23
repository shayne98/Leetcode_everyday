package leecode.BFS.No310;

import java.util.*;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        //一个节点的时候无边，需要单独考虑
        if(n<2){
            for(int i=0;i<n;i++)
                leaves.add(i);
            return leaves;
        }
        //对象数组的用法
        List<Integer>[] nearPoint = new List[n];
        for(int i=0;i<n;i++){
            //存放与i相连的节点
            nearPoint[i]=new LinkedList<Integer>();
        }
        //记录遍历到的叶子节点数，每次遍历到了就减一
        int leafNum =n;
        //记录每个点与之相邻的节点
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            nearPoint[x].add(y);
            nearPoint[y].add(x);
        }
        //得到相邻节点数为1的节点即为叶子节点
        for(int i=0;i<n;i++){
            if(nearPoint[i].size()==1){
                leaves.add(i);
            }
        }
        //当叶子节点剩下2及以下时，剩下的节点就是所要求的中心节点，也就是题目要求的节点
        while(leafNum>2){
            ArrayList<Integer> newLeaves = new ArrayList<>();
            //去掉和当前叶子节点相连的节点关系
            for (Integer leaf : leaves) {
                int temp = nearPoint[leaf].get(0);
                nearPoint[temp].remove(Integer.valueOf(leaf));
                //去掉叶子节点关系后，节点相连数为1说明是新的叶子节点
                if(nearPoint[temp].size()==1)newLeaves.add(temp);
                //遍历一个叶子节点数，leafNum更新
                leafNum--;
            }
            //更新新的叶子节点
            leaves = newLeaves;
        }
        return leaves;

    }

}