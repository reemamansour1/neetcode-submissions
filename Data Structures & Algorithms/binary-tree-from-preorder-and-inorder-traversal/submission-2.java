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

    HashMap<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        // what is?
        return dfs(preorder, 0, inorder.length - 1);
    }
    private TreeNode dfs(int[] preorder, int l , int r){
        if(l>r) return null;
        // why ++?
        int val = preorder[preIndex++];
        TreeNode root = new TreeNode(val);
        // mid is the index of the root in the inorder array 
        // so it will be left, root, right -> root, 
        int mid = map.get(val);
        // what is root.left equal to?
        root.left = dfs(preorder, l, mid-1);
        root.right = dfs(preorder, mid+1, r);
        return root;
    }
}
