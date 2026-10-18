class Solution {


    // When I find a 1, I explore everything connected to it, and that whole connected group counts as one island, even if it’s just a single 1
    public int numIslands(char[][] grid) {
        int c = grid[0].length;
        int r = grid.length;
        int count = 0;
        for(int i = 0; i < r; i++){
            for (int j = 0; j<c; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;

    }

    public void dfs(char[][] grid, int r, int c){
        int ROW = grid.length;
        int COL = grid[0].length;
 
        if (r < 0 || c < 0 || r >= ROW || c >= COL || grid[r][c] == '0') return;

        grid[r][c] = '0';

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);

    }
}
