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

        TreeNode curr = root;

        // why do we need a while loop?
        while(curr != null){
            if(q.val < curr.val && p.val < curr.val) {curr = curr.left;}
            else if(q.val > curr.val && p.val > curr.val){ curr = curr.right;}
            else {return curr;}
        }
        return null;


        
    } 
}
