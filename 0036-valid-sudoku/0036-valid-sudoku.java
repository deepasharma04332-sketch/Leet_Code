class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.') continue;
                String row ="r" + i + val;
                String col ="c" + j + val;
                String box ="b" + (i / 3) + (j / 3) + val;
                
                if (!seen.add(row) || !seen.add(col) || !seen.add(box)) {
                    return false;
                }
            }}
        return true;}
}