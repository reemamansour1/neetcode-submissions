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

public class Codec {
    // Shared index: points to the next unread token.
    private int i;

    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);

        // Example: "1,2,N,N,3,N,N"
        return String.join(",", res);
    }

    private void dfsSerialize(TreeNode node, List<String> res) {
        if (node == null) {
            // Preserve missing children so we can rebuild the exact shape.
            res.add("N");
            return;
        }

        // PREORDER: root, then entire left subtree, then right subtree.
        res.add(String.valueOf(node.val));
        dfsSerialize(node.left, res);
        dfsSerialize(node.right, res);
    }

    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");

        // Reset for every new tree we deserialize.
        i = 0;

        return dfsDeserialize(vals);
    }

    // Builds a subtree and returns its root with children attached.
    private TreeNode dfsDeserialize(String[] vals) {
        if (vals[i].equals("N")) {
            // "N" is a token too: consume it before returning.
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[i]));

        // We have consumed this node's value.
        // Advance BEFORE the child calls, or they will read it again.
        i++;

        // Left call consumes every token belonging to the left subtree.
        node.left = dfsDeserialize(vals);

        // The shared index now points to the right subtree's first token.
        node.right = dfsDeserialize(vals);

        // Returning this node also gives access to its attached children.
        return node;
    }
}
