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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // so does the LCA means returning the closest ansestor?
        // yes, so we need to return the closest root

        if(p.val < root.val && q.val < root.val){
            // it means the LCA is in the left subtree
            return lowestCommonAncestor(root.left, p,q);
        }
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p,q);
        }

        return root;

        // how would i solve this?

        // like i want to check both nodes root's
        
        // i want also to consdier that one of them could be the lca

        // i want to return the closest ones
    } 
}
