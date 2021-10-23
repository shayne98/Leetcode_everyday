package leecode.DFS_Backtracking.No47;

import java.util.*;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    boolean [] flag;
    public List<List<Integer>> permuteUnique(int[] nums) {
        //先进行排序，使得相同的值挨在一起
        Arrays.sort(nums);
        LinkedList temp = new LinkedList();
        flag= new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            //对于相同的值，规定只能位置在前的必须比排在位置靠后的先遍历，这样就不会重复选择了
            if(i>0&&nums[i]==nums[i-1]&&!flag[i-1])continue;
            DFS(i,temp,nums);
        }
        return ans;

    }
    void DFS(int n,LinkedList temp,int[]nums){
        temp.addLast(nums[n]);
        flag[n]=true;
        //全部遍历完成，将temp存入ans
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            flag[n]=false;
            temp.pollLast();
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]&&!flag[i-1])continue;
            if(flag[i]==false)DFS(i,temp,nums);

        }
        flag[n]=false;
        temp.pollLast();
        return;
    }
}