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

    // Encodes a tree to a single string.
    int i;
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        return String.join("," , res);
    }
    public void dfsSerialize(TreeNode node, List<String> res){
        if(node == null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val));
        dfsSerialize(node.left, res);
        dfsSerialize(node.right, res);
    }

    // i do not understand why int[] i is a second parm?
    public TreeNode dfsDeserialize(String[] vals){
        if(vals[i].equals("N")){
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
       
        i++;
        node.left = dfsDeserialize(vals);
        node.right = dfsDeserialize(vals);
        return node;
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        i = 0;
        return dfsDeserialize(vals);
    }
}
