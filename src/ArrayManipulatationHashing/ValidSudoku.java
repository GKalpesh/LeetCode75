package ArrayManipulatationHashing;

import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','9','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int n = 9;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int currentBoxNum = 3 * (i/3) + j/3;
                char currentValue = board[i][j];
                if (currentValue != '.'){
                    boolean isPresentInRow = rows[i].contains(currentValue);
                    boolean isPresentInColumn = cols[j].contains(currentValue);
                    boolean isPresentInBox = boxes[currentBoxNum].contains(currentValue);

                    if (isPresentInRow || isPresentInColumn || isPresentInBox) return false;

                    rows[i].add(currentValue);
                    cols[j].add(currentValue);
                    boxes[currentBoxNum].add(currentValue);
                }
            }
        }
        return true;
    }
}
