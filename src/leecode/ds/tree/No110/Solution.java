package leecode.ds.tree.No110;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/15 21:08
 * 110. Balanced Binary Tree
 */
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
    public boolean isBalanced(TreeNode root) {
        return root == null?true:helper(root)!=-1;

    }
    public int helper(TreeNode root){
        if(root==null)return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left==-1||right == -1||Math.abs(left-right)>1)return -1;
        else return Math.max(left,right)+1;

    }
}