import java.util.Scanner;

public class NQueens {
    private int[][] board;
    private int n;

    public NQueens(int n) {
        this.n = n;
        board = new int[n][n];
    }

    public boolean isSafe(int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean solveNQueensUtil(int col) {
        if (col >= n) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;
                if (solveNQueensUtil(col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the board (n): ");
        int n = scanner.nextInt();
        System.out.print("Enter the row and column of the first queen (0-based index): ");
        int firstRow = scanner.nextInt();
        int firstCol = scanner.nextInt();

        NQueens nQueens = new NQueens(n);
        nQueens.board[firstRow][firstCol] = 1;

        if (nQueens.solveNQueensUtil(1)) {
            System.out.println("Solution:");
            nQueens.printBoard();
        } else {
            System.out.println("No solution exists for the given initial placement.");
        }
        scanner.close();
    }
}

/*
 * Enter the size of the board (n): 4
 * Enter the row and column of the first queen (0-based index): 1 0
 * Solution:
 * 0 0 1 0
 * 1 0 0 0
 * 0 0 0 1
 * 0 1 0 0
 */