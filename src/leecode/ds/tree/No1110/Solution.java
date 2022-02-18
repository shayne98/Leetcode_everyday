package leecode.ds.tree.No1110;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/18 15:19
 * 1110. Delete Nodes And Return Forest
 * 一方面需要删除父节点对该节点的连接，一方面要注意何时将新的树的根节点放入list（父节点为非null，
 */
@SuppressWarnings("all")
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
  @SuppressWarnings("all")
class Solution {
    List<TreeNode> trees = new ArrayList<>();
    boolean[] exist = new boolean[1010];
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int num:to_delete){
            exist[num] = true;
        }
        helper(null,root);
        return trees;
    }
    public void helper(TreeNode father,TreeNode root){
        if(root==null)return;
        TreeNode nextFa = root;
        //root.val存在的情况下，需要删除root，下一个递归节点的父节点置为null
        if(exist[root.val]==true){
            nextFa = null;
        }
        //root保留的情况下若父节点被删除，则该root是新树的根节点
        else if(father == null){
            trees.add(root);
        }
        //向子节点进行递归
        helper(nextFa, root.left);
        helper(nextFa,root.right);
        //若子节点中有需要删除的节点，父节点和该子节点的连接断开
        if(root.left!=null&&exist[root.left.val]==true)root.left = null;
        if(root.right!=null&&exist[root.right.val]==true)root.right = null;
    }
}