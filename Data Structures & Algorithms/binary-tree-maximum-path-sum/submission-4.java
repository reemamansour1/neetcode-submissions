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
        // why did we assign it to min value?
        best = Integer.MIN_VALUE;
        gain(root);
        return best;
    }

    private int gain(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, gain(node.left));
        // why are we putting 0, gain.. why not min value?
        int right = Math.max(0, gain(node.right));

        best = Math.max(best, left + node.val + right);
        // why are we not returning the best?

        // or are we returning the max path fron this node until all its kids are null? 
        // so are we returning that node and whichever has a bigger value for its left subtree and right subtree?

        return node.val + Math.max(left, right);
    }
}
