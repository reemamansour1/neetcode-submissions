class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            //  i think i memorized that col = mid%cols
            // why over how many cols do we have not rows>
            // ANSWER: because each ROW has "cols" number of elements.
            // think of the matrix flattened into 1D - every "cols" elements = one row.
            // so to know which row a flat index belongs to, divide by how big each row is (cols)
            
            // and why row is / but col is %?
            // ANSWER: row = mid / cols tells you how many FULL rows you've passed (the group)
            // col = mid % cols tells you the LEFTOVER position within that row (the position)
            // example: cols=4, mid=9 -> row = 9/4 = 2, col = 9%4 = 1 -> matrix[2][1]
            // mid=9 means you've passed 2 full rows (8 elements) and are 1 element into row 2
            
            // i thought we divde the index/col not mid but wait right in this case mid is the index that keeps moving right? like mid is kinda i for this q
            // ANSWER: yes exactly! mid IS the flat index for this iteration.
            // in binary search, mid plays the role of "the current index we're checking"
            // same as "i" in a normal loop, except instead of incrementing by 1, 
            // it jumps based on left/right boundaries
            int row = mid / cols;
            int col = mid % cols;
            
            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}