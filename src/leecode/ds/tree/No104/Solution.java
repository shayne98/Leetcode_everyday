package leecode.ds.tree.No104;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/15 20:57
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
    public int maxDepth(TreeNode root) {
        return root==null?0:Math.max(maxDepth(root.right),maxDepth(root.left))+1;
    }
}