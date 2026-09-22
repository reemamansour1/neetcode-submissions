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
    // Preorder tells us which node to create next.
    // Inorder tells us which nodes belong to its left and right subtrees.
    HashMap<Integer, Integer> map = new HashMap<>();

    // Shared index pointing to the next unread preorder value.
    int i;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Reset state in case this Solution object is reused.
        i = 0;

        // Map each value to its position in inorder.
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Build the whole tree using the full inorder range.
        return dfs(preorder, 0, inorder.length - 1);
    }

    // Build the subtree for inorder positions l through r, inclusive.
    private TreeNode dfs(int[] preorder, int l, int r) {
        // An empty range means there is no child here.
        if (l > r) return null;

        // Read the next root value, then advance BEFORE building children.
        int val = preorder[i++];
        TreeNode root = new TreeNode(val);

        // Find this root's position in inorder to split the current range.

        int mid = map.get(val);

        // Build and attach the left subtree: inorder positions l to mid - 1.
        root.left = dfs(preorder, l, mid - 1);

        // Build and attach the right subtree: positions mid + 1 to r.
        // Build left first because preorder follows root → left → right.
        root.right = dfs(preorder, mid + 1, r);

        // Return this subtree's root with both children already attached.
        return root;
    }
}