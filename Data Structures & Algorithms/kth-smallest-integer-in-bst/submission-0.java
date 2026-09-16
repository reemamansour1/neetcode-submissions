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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);
        // why do we need to sort?
        // isn't the BST is already sorted?
        // we are adding left, root, right
        // or is it because in the dfs function we are adding root.val then we are doing recursion from left then right so we are bascially not using the fact that the BST is already sorted?
        Collections.sort(arr);
        return arr.get(k-1);
    }
    public void dfs(TreeNode root, List<Integer> arr){
        if(root == null) return;
        arr.add(root.val);
        dfs(root.right, arr);
        dfs(root.left, arr);
    }
}
