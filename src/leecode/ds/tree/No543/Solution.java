package leecode.ds.tree.No543;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/15 21:18
 * 543. Diameter of Binary Tree
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
    int num = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return num;
    }
    public int helper(TreeNode root){
        if(root == null)return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        num = Math.max(num,left+right);
        return Math.max(left,right)+1;
    }
}
