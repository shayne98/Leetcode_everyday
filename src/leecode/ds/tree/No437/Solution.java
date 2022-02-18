package leecode.ds.tree.No437;


/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/17 14:02
 * 437. Path Sum III
 * 按是否包含该节点进行向子树递归
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
    int value;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)return 0;
        //前两个是表示root点不作为首个点的情况，最后一个表示root点作为首个点的情况
        return pathSum(root.left,targetSum)+pathSum(root.right,targetSum)+helper(root,targetSum);

    }
    public int helper(TreeNode root,int targetSum){
        if(root==null)return 0;
        int count = 0;
        if(targetSum-root.val==0)count++;
        count+=helper(root.left,targetSum-root.val);
        count+=helper(root.right,targetSum-root.val);
        return count;
    }
}