package leecode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] list = new List[n];
        LinkedList<Integer> leaves = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int leafNum =n;
        if(n<=2){
            for(int i=0;i<n;i++){
                ans.add(i);
            }
            return ans;
        }
        for(int i=0;i<n;i++){
            list[i]= new LinkedList<>();
        }
        for(int i=0;i<edges.length;i++){
            int x = edges[i][0];
            int y = edges[i][1];
            list[x].add(y);
            list[y].add(x);
        }
        for(int i=0;i<n;i++){
            if(list[i].size()==1)leaves.add(i);
        }
        while(leafNum>2){
            LinkedList<Integer> newLeaves = new LinkedList<>();
            for (Integer leaf : leaves) {
                int temp = list[leaf].get(0);
                list[temp].remove(Integer.valueOf(leaf));
                if(list[temp].size()==1)
                    newLeaves.add(temp);
                leafNum--;
                leaves = newLeaves;
            }
        }
        for(int i=0;i<leaves.size();i++){
            ans.add(leaves.get(i));
        }
        return ans;

    }
}