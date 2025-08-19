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
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null)  return result;
        dfs(root, new ArrayList<>(), targetSum);
        return result;
    }
    private void dfs(TreeNode node, List<Integer> slate, int target){

        slate.add(node.val);
        target -= node.val;

        if(node.left == null && node.right == null){
            if(target == 0){
                result.add(new ArrayList<>(slate));
            }
            slate.remove(slate.size() - 1);
            return;
        }

        if(node.left != null) dfs(node.left, slate, target);
        if(node.right != null) dfs(node.right, slate, target);

        slate.remove(slate.size() - 1);
    }
}