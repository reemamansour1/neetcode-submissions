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

    // STUCK #1: bounds BEFORE reading board[r][c].
    // You can't ask what's in a cell until you know the cell exists.
    // '#' means "already used in the current path".
    if (r < 0 || c < 0 || r >= ROW || c >= COL || board[r][c] == '#') return;

    // STUCK #2: "what goes inside get/containsKey?"
    // The cell's letter: board[r][c].
    // No branch for this letter means no word continues this way, so stop.
    // Use containsKey. get() returns a TrieNode (or null), never a char.
    if (!node.map.containsKey(board[r][c])) return;

    // STUCK #3: "what is child?"
    // child is a TrieNode, NOT a String.
    // node  = trie spot BEFORE typing this cell's letter
    // child = trie spot AFTER typing it (node + one letter)
    TrieNode child = node.map.get(board[r][c]);

    // STUCK #4: "how do I get the word string?"
    // The end node stores its own word. Check child, not node,
    // because a word is only complete once THIS cell's letter is included.
    // word is a String, so compare to null (can't use it as a boolean).
    if (child.word != null) {
        res.add(child.word);
        child.word = null;   // clear it so the same word isn't added twice
    }

    // STUCK #5: "what is letter?"
    // letter is the original CHAR on the board, not a trie thing.
    // Save it BEFORE writing '#', or you lose it.
    char letter = board[r][c];
    board[r][c] = '#';       // mark: used in this path

    // STUCK #6: "why child and not node?"
    // Board finger and trie finger move together.
    // The neighbor's "before" is this cell's "after".
    // No || and no return: we want ALL words, so all 4 directions always run.
    dfs(board, child, r + 1, c);
    dfs(board, child, r - 1, c);
    dfs(board, child, r, c + 1);
    dfs(board, child, r, c - 1);

    // Unmark (backtrack): frees the cell for other words and other starts.
    board[r][c] = letter;
}
}
