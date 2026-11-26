class Solution {
    public int minMoves(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < minVal) {
                minVal = num;
            }
        }

        int moves = 0;
        for (int num : nums) {
            moves += num - minVal;
        }

        return moves;
    }
}