public class Sudoku{
    public static boolean check(char[][] puzzle) {
        // checks the rows for 1 through 9
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char current = puzzle[i][j];
                if (current != '.') {
                    int num = current - '1';
                    if (row[num]) {
                        return false;
                    }
                    row[num] = true;
                }
            }
        }

        // checks the columns for 1 through 9
        for (int j = 0; j < 9; j++) {
            boolean[] column = new boolean[9];
            for (int i = 0; i < 9; i++) {
                char current = puzzle[i][j];
                if (current != '.') {
                    int num = current - '1';
                    if (column[num]) {
                        return false;
                    }
                    column[num] = true;
                }
            }
        }

        // checks the 3 by 3 sets
        for (int block = 0; block < 9; block++) {
            boolean[] set = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    char current = puzzle[i][j];
                    if (current != '.') {
                        int num = current - '1';
                        if (set[num]) {
                            return false;
                        }
                        set[num] = true;
                    }
                }
            }
        }

        return true;
    }

    private static boolean solveMan(char[][] puzzle) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (puzzle[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        // temporarily place the number in the cell
                        puzzle[i][j] = num;

                        // check if the puzzle is still valid after placing the number
                        if (check(puzzle) == true) {
                            // recursively try to solve the rest of the puzzle
                            if (solveMan(puzzle)) {
                                return true; // puzzle is solved
                            }
                        }

                        // backtrack: remove the number and try the next one
                        puzzle[i][j] = '.';
                    }
                    return false; // no valid number found for the cell
                }
            }
        }
        return true; // puzzle is solved (all cells filled)
    }

    private static void printPuzzle(char[][] puzzle) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------"); // horizontal border
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| "); // vertical border
                }
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println(); // new line after each row
        }
    }

    public static boolean solve(char[][] puzzle) {
        if (check(puzzle) == false) {
            System.out.println("The given Sudoku puzzle is invalid");
            return false;
        }

        if (solveMan(puzzle) == true) {
            printPuzzle(puzzle);
            return true;
        } else {
            System.out.println("This puzzle is unsolvable");
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] puzzle = SudokuP.puzzle();
        Sudoku.solve(puzzle);
    }
}
