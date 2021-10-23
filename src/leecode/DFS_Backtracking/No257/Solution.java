package leecode.DFS_Backtracking.No257;

/**
 * @author 小羊Shaun
 * @version 1.0
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuffer temp = new StringBuffer();
        temp.append(root.val);
        if(root.left==null&&root.right==null)ans.add(temp.toString());
        if(root.left!=null)DFS(root.left,temp);
        if(root.right!=null)DFS(root.right,temp);
        return ans;

    }
    void DFS(TreeNode node ,StringBuffer temp){
        int len = temp.length();
        temp.append("->"+Integer.toString(node.val));
        if(node.left==null&&node.right==null)ans.add(temp.toString());
        if(node.left!=null)DFS(node.left,temp);
        if(node.right!=null)DFS(node.right,temp);
        temp.delete(len,temp.length());
        return;


    }
}