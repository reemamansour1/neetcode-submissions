class Solution {
    private int ROW, COL;

    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;

        for(int i = 0; i<ROW; i++){
            for(int j = 0; j<COL; j++){
                 if(dfs(board, i, j, 0, word)){
                    return true;
                 }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int r, int c, int i, String word){
        if(i == word.length()) return true;

        // we will mark characters as # when we visit them within one path

        if(r >= ROW || c >= COL || r < 0 || c < 0 || board[r][c] != word.charAt(i) || board[r][c] == '#') return false;

        board[r][c] = '#';
        // hey wait, why the res is || between all four directions?
        boolean res = dfs(board, r + 1, c, i+1, word) || dfs(board, r - 1, c, i+1, word) || dfs(board, r, c + 1, i+1, word) || dfs(board, r , c -1, i+1, word);

        board[r][c] = word.charAt(i);
        return res;

    }
}
