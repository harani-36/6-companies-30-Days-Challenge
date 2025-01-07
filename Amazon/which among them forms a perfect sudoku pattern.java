import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> boxSet = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!rowSet.add(board[i][j])) {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (!colSet.add(board[j][i])) {
                        return false;
                    }
                }
                int boxRow = 3 * (i / 3) + j / 3;
                int boxCol = 3 * (i % 3) + j % 3;
                if (board[boxRow][boxCol] != '.') {
                    if (!boxSet.add(board[boxRow][boxCol])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
