class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(0, n, board, result, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return result;
    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> result, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            result.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            int id1 = row - col + n;
            int id2 = row + col;
            if (!cols[col] && !d1[id1] && !d2[id2]) {
                board[row][col] = 'Q';
                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;
                backtrack(row + 1, n, board, result, cols, d1, d2);
                board[row][col] = '.';
                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}