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
        if (root == null) return false;

        // why when i add this base case it makes it not work?

        
        targetSum -= root.val;

        if(root.left == null && root.right == null) return targetSum == 0;


        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum) || (targetSum == 0 && root.left == null && root.right == null);
    }
    
}