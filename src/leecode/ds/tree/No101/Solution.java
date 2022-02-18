package leecode.ds.tree.No101;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/18 17:47
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return helper(root.left,root.right);


    }
    public boolean helper(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null)return true;
        if(t1!=null&&t2!=null&&t1.val==t2.val){
            return helper(t1.left,t2.right)&&helper(t1.right,t2.left);
        }
        else return false;
    }
}