class TrieNode{
    Map<Character, TrieNode> map = new HashMap<>();
    // for this question, instead of having an end prop, we made a word so we can have the whole word when it is at the end of it and actually store that word inside the word
    String word = null;
}

class Solution {
    TrieNode root = new TrieNode();
    List<String> res = new ArrayList<>();
    int ROW,COL;

    public List<String> findWords(char[][] board, String[] words) {
        ROW = board.length;
        COL = board[0].length;


        for(String word: words){
            insert(word);
        }

        for(int r = 0; r<ROW; r++){
            for(int c = 0; c < COL; c++){
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

        // if it is the end, how do i write it in code that to add this string to the res arraylist?


        // here what do i put inside the get?
        // board[r][c] != node.map.get()



        if(r < 0 || c < 0 || r >= ROW || c >= COL || board[r][c] == '#') return;

        // so this is to check if there is a branch for this letter?
        if(!node.map.containsKey(board[r][c])) return;


        TrieNode child = node.map.get(board[r][c]);


        if(child.word != null) {
            res.add(child.word);
            child.word = null;
           
        } // node is a node not a string


        char letter = board[r][c];

        // how am i going to add the word in the list 


        // where am i going to do the dfs?



        board[r][c] = '#';

        dfs(board, child, r + 1, c);
        dfs(board, child, r - 1, c);
        dfs(board, child, r, c + 1);
        dfs(board, child, r, c - 1);


        // this is the end to restore from # to the orginial letter
        board[r][c] = letter;




    }
}
