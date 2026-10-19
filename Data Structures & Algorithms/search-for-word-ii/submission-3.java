class TrieNode{
    Map<Character, TrieNode> map = new HashMap<>();
    String word = null;
}

class Solution {
    TrieNode root = new TrieNode();
    int ROW, COL;
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        ROW = board.length;
        COL = board[0].length;

        for(String word: words){
            insert(word);
        }

        for(int r = 0; r<ROW; r++){
            for(int c = 0; c<COL; c++){
                dfs(board, root, r, c);
            }
        }
        return res;
    }

    public void insert(String word) {
    TrieNode curr = this.root;
    for (char c : word.toCharArray()) {
        if (!curr.map.containsKey(c)) {
            curr.map.put(c, new TrieNode());
        }
        curr = curr.map.get(c);
    }
    curr.word = word;
    }


    public void dfs(char[][] board, TrieNode node, int r, int c){
        // start with base case for bonds
        if(r >= ROW || c >= COL || r < 0 || c < 0) return;

        // check if this node has a this branch

        if(!node.map.containsKey(board[r][c])) return;

        // check if this letter is already visited

        if(board[r][c] == '#') return;

        // now im not sure what child is, is it the string that holds all of it?

        TrieNode child = node.map.get(board[r][c]);

        if(child.word != null){
            res.add(child.word);
            child.word = null;
        }

        char letter = board[r][c];

        board[r][c] = '#';
        dfs(board, child, r+1, c);
        dfs(board, child, r-1, c);
        dfs(board, child, r, c+1);
        dfs(board, child, r, c-1);

        board[r][c] = letter;

    }
}
