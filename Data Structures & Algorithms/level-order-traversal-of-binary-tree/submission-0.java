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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // since it is level by level 
        // i am assuming i need to do BFS
        // which means queue

        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root != null ) q.offer(root);

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            // TreeNode curr = q.poll();
            // what if there is more than one number in a level???

            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left != null){
                q.offer(curr.left);
                }
                if(curr.right != null){
                q.offer(curr.right);
                } }
                res.add(level);
            }
        return res;
        
    }
}
