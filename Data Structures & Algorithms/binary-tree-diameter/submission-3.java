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
    public int diameterOfBinaryTree(TreeNode root) {
        
        if (root == null) return 0;
        // first calculate the depth in the left plus depth in the right

        // the sum gives me the total edges in the BT. correct?

        // for the first example, 1,null,2,3,4,5

        // left subtree depth is 0
        
        // right subtree depth is 4

        int sum = depth(root.left) + depth(root.right);

        // sum is 4

        // what would be the case that the sum would not be the max? 



        int left = diameterOfBinaryTree(root.left);

        // or right subtree
        int right = diameterOfBinaryTree(root.right);

        return Math.max(sum, Math.max(left, right));
        

    }
    // same funtion to calculate how many nodes we have from the root dowm
    public int depth(TreeNode root){

        if(root == null) return 0;

        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
