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
    public boolean isValidBST(TreeNode root) {
        // Initially, allow every possible int value.
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode node, long lower, long upper) {
        // An empty subtree breaks no BST rules.
        if (node == null) return true;

        // This node must obey all bounds inherited from its ancestors.
        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        // Left values must be below this node.
        // Right values must be above this node.
        // Preserve the other bound inherited from ancestors.
        return valid(node.left, lower, node.val)
            && valid(node.right, node.val, upper);
    }
}