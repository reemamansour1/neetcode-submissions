class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean end = false;
}
class WordDictionary {
    TrieNode root;
    Map<Character, TrieNode> children;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    public boolean dfs(String word, int i, TrieNode node){
        if(i == word.length()){
            return node.end;
        }
        char c = word.charAt(i);
        if(c == '.'){
            for(TrieNode child : node.children.values()){
                if(dfs(word, i+1, child)){
                    return true;
                }
            }
            return false;
        }
        if(!node.children.containsKey(c)){
            return false;
        }
        return dfs(word, i + 1, node.children.get(c));
   
}}
