class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Use BFS to visit the tree level by level.
        // Use ArrayDeque as a queue: offer at the back, poll from the front.
        Queue<TreeNode> q = new ArrayDeque<>();

        // Store one list of values for each level.
        List<List<Integer>> res = new ArrayList<>();

        // ArrayDeque does not allow null elements.
        if (root != null) q.offer(root);

        // Each iteration processes one whole level.
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            // Save the number of nodes in this level before adding children.
            int size = q.size();

            // Process exactly those nodes.
            for (int i = 0; i < size; i++) {
                // Remove the next waiting node.
                TreeNode curr = q.poll();
                level.add(curr.val);

                // Children join the back to wait for the next level.
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            // Add the completed level to the result.
            res.add(level);
        }

        return res;
    }
}