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
    private int best;

    public int maxPathSum(TreeNode root) {
        // The answer could be negative, so don't start at 0.
        best = Integer.MIN_VALUE;

        gain(root);

        // Best complete path anywhere, not just starting at root.
        return best;
    }

    private int gain(TreeNode node) {
        if (node == null) return 0;

        // Each child's returned number becomes my left/right contribution.
        // Use 0 to skip a branch if its sum is negative.
        int left = Math.max(0, gain(node.left));
        int right = Math.max(0, gain(node.right));

        // A complete path can connect both sides through this node.
        // Save it as a possible final answer.
        best = Math.max(best, left + node.val + right);

        // My parent will add its own value to the contribution I return.
        // Return only ONE branch so it can extend the path without a fork.
        // The two-sided path above is already remembered in best.
        return node.val + Math.max(left, right);
    }
}
