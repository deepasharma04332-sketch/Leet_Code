class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        backtrack(0, 0, 0, 0, n);
        return count;}
    private void backtrack(int row, int cols, int diags1, int diags2, int n) {
        if (row == n) {
            count++;
            return;
        }

        int availablePositions = ((1 << n) - 1) & (~(cols | diags1 | diags2));

        while (availablePositions != 0) {
            int p = availablePositions & -availablePositions;
            availablePositions -= p;

            backtrack(row + 1, cols | p, (diags1 | p) << 1, (diags2 | p) >> 1, n);
        }
    }
}