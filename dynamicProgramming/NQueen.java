package codes.dynamicProgramming;
public class NQueen {

    int N = 4;

    boolean isSafe(int board[][], int row, int col) {

        // Check row
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Lower diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    boolean solveNQUtil(int board[][], int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQUtil(board, col + 1))
                    return true;

                board[i][col] = 0; // backtrack
            }
        }
        return false;
    }

    void solveNQ() {
        int board[][] = new int[N][N];

        if (!solveNQUtil(board, 0)) {
            System.out.println("No solution exists");
            return;
        }

        printSolution(board);
    }

    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueen obj = new NQueen();
        obj.solveNQ();
    }
}