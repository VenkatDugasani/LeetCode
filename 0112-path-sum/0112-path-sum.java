/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean flag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        dfs(root, targetSum);
        return flag;
    }

    private void dfs(TreeNode node, int target){

        if(node.left == null && node.right == null){
            if(target == node.val){
                flag = true;
            }
            return;
        }

        if(node.left != null){
            dfs(node.left, target - node.val);
        }
        if(node.right != null){
            dfs(node.right, target - node.val);
        }
    }
};
