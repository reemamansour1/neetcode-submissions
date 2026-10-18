class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int max = 0;
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }


        return max;
        
    }

    public int dfs(int[][] grid, int r, int c){
        int ROW = grid.length; 
        int COL = grid[0].length;
        if (r < 0 || c < 0 || r >= ROW || c >= COL || grid[r][c] == 0) return 0;

        grid[r][c] = 0;
        int area = 1;

        area += dfs(grid, r+1, c);
        area += dfs(grid, r-1, c);
        area += dfs(grid, r, c+1);
        area += dfs(grid, r, c-1);

        return area;


    }
}
