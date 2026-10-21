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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }
    public boolean dfs(TreeNode root, int target, int curr){
        if(root == null) return false;

        curr += root.val;

        // if it is a leaf, no left no right

        if(root.left == null && root.right == null){
            return curr == target;
        }

        return dfs(root.left,target, curr) || dfs(root.right, target, curr);
    }
}