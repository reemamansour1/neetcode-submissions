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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // first step always handle edge cases:
        if(preorder.length == 0 || inorder.length == 0) return null;
        // we are creating a root node, so new TreeNode()
        TreeNode root = new TreeNode(preorder[0]);
        // mid will be the index of the root in the in order array
        int mid = -1;
        for(int i = 0; i<inorder.length; i++){
            if(inorder[i] == preorder[0]){
                mid = i;
                break;
            }
        }
        int[] leftpreorder = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] leftinorder = Arrays.copyOfRange(inorder, 0, mid);
        // now i do not understand how doing this recursively builds the left subtree. i think i have this issue in every BT question, like i do not know how ti understnad it.
        root.left = buildTree(leftpreorder, leftinorder);

        int[] rightpreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightinorder = Arrays.copyOfRange(inorder, mid +1, inorder.length);

        root.right = buildTree(rightpreorder, rightinorder);

        return root;
        
    }
}
