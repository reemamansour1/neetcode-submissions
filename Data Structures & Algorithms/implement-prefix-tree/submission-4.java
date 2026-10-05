public class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    // char is the key
    // trienode is the value

    // trienode is a map and end
    boolean end = false;
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
            }
            // why are we assiging curr to curr.children.get(c);
            // is it because current will equal whatever we inputed/inserted into 

            curr = curr.children.get(c);
        }
        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
            // why this line
            curr = curr.children.get(c);
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
            // why this line
            curr = curr.children.get(c);
        }
        return true;
    }
}
